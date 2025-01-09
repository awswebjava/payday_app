package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tipo_obligacionwwgetfilterdata extends GXProcedure
{
   public tipo_obligacionwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipo_obligacionwwgetfilterdata.class ), "" );
   }

   public tipo_obligacionwwgetfilterdata( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      tipo_obligacionwwgetfilterdata.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      tipo_obligacionwwgetfilterdata.this.AV34DDOName = aP0;
      tipo_obligacionwwgetfilterdata.this.AV35SearchTxt = aP1;
      tipo_obligacionwwgetfilterdata.this.AV36SearchTxtTo = aP2;
      tipo_obligacionwwgetfilterdata.this.aP3 = aP3;
      tipo_obligacionwwgetfilterdata.this.aP4 = aP4;
      tipo_obligacionwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV41EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      tipo_obligacionwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV41EmpCod = GXt_int1 ;
      GXt_int3 = AV42CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      tipo_obligacionwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV42CliCod = GXt_int3 ;
      AV24Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV26OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV27OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWtipo_obligacion", GXv_boolean6) ;
      tipo_obligacionwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV8IsAuthorized = GXt_boolean5 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext7[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext7) ;
         AV9WWPContext = GXv_SdtWWPContext7[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV34DDOName), "DDO_TIPOOBLCODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADTIPOOBLCODIGOOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV34DDOName), "DDO_TIPOOBLDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADTIPOOBLDESCRIPOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV34DDOName), "DDO_EMBARGADESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADEMBARGADESCRIPOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV37OptionsJson = AV24Options.toJSonString(false) ;
      AV38OptionsDescJson = AV26OptionsDesc.toJSonString(false) ;
      AV39OptionIndexesJson = AV27OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV29Session.getValue("tipo_obligacionWWGridState"), "") == 0 )
      {
         AV31GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "tipo_obligacionWWGridState"), null, null);
      }
      else
      {
         AV31GridState.fromxml(AV29Session.getValue("tipo_obligacionWWGridState"), null, null);
      }
      AV52GXV1 = 1 ;
      while ( AV52GXV1 <= AV31GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV32GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV31GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV52GXV1));
         if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOOBLCODIGO") == 0 )
         {
            AV12TFTipoOblCodigo = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOOBLCODIGO_SEL") == 0 )
         {
            AV11TFTipoOblCodigo_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFTipoOblCodigo_Sels.fromJSonString(AV11TFTipoOblCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOOBLDESCRIP") == 0 )
         {
            AV15TFTipoOblDescrip = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOOBLDESCRIP_SEL") == 0 )
         {
            AV14TFTipoOblDescrip_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFTipoOblDescrip_Sels.fromJSonString(AV14TFTipoOblDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOOBLANTI_SEL") == 0 )
         {
            AV17TFTipoOblAnti_Sel = (byte)(GXutil.lval( AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOOBLTOTTIPO_SEL") == 0 )
         {
            AV18TFTipoOblTotTipo_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV19TFTipoOblTotTipo_Sels.fromJSonString(AV18TFTipoOblTotTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMBARGADESCRIP") == 0 )
         {
            AV47TFEmbargaDescrip = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMBARGADESCRIP_SEL") == 0 )
         {
            AV46TFEmbargaDescrip_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV48TFEmbargaDescrip_Sels.fromJSonString(AV46TFEmbargaDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV49MenuOpcCod = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV52GXV1 = (int)(AV52GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADTIPOOBLCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV12TFTipoOblCodigo = AV35SearchTxt ;
      AV13TFTipoOblCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV54Tipo_obligacionwwds_1_tftipooblcodigo = AV12TFTipoOblCodigo ;
      AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels = AV13TFTipoOblCodigo_Sels ;
      AV56Tipo_obligacionwwds_3_tftipoobldescrip = AV15TFTipoOblDescrip ;
      AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels = AV16TFTipoOblDescrip_Sels ;
      AV58Tipo_obligacionwwds_5_tftipooblanti_sel = AV17TFTipoOblAnti_Sel ;
      AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels = AV19TFTipoOblTotTipo_Sels ;
      AV60Tipo_obligacionwwds_7_tfembargadescrip = AV47TFEmbargaDescrip ;
      AV61Tipo_obligacionwwds_8_tfembargadescrip_sels = AV48TFEmbargaDescrip_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1164TipoOblCodigo ,
                                           AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels ,
                                           A1165TipoOblDescrip ,
                                           AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels ,
                                           Byte.valueOf(A1168TipoOblTotTipo) ,
                                           AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels ,
                                           A1162EmbargaDescrip ,
                                           AV61Tipo_obligacionwwds_8_tfembargadescrip_sels ,
                                           Integer.valueOf(AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels.size()) ,
                                           AV54Tipo_obligacionwwds_1_tftipooblcodigo ,
                                           Integer.valueOf(AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels.size()) ,
                                           AV56Tipo_obligacionwwds_3_tftipoobldescrip ,
                                           Byte.valueOf(AV58Tipo_obligacionwwds_5_tftipooblanti_sel) ,
                                           Integer.valueOf(AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels.size()) ,
                                           Integer.valueOf(AV61Tipo_obligacionwwds_8_tfembargadescrip_sels.size()) ,
                                           AV60Tipo_obligacionwwds_7_tfembargadescrip ,
                                           Short.valueOf(AV45PaiCod) ,
                                           Boolean.valueOf(A1167TipoOblAnti) ,
                                           Short.valueOf(A1159TipoOblPaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.SHORT
                                           }
      });
      lV54Tipo_obligacionwwds_1_tftipooblcodigo = GXutil.padr( GXutil.rtrim( AV54Tipo_obligacionwwds_1_tftipooblcodigo), 20, "%") ;
      lV56Tipo_obligacionwwds_3_tftipoobldescrip = GXutil.concat( GXutil.rtrim( AV56Tipo_obligacionwwds_3_tftipoobldescrip), "%", "") ;
      lV60Tipo_obligacionwwds_7_tfembargadescrip = GXutil.concat( GXutil.rtrim( AV60Tipo_obligacionwwds_7_tfembargadescrip), "%", "") ;
      /* Using cursor P019E2 */
      pr_default.execute(0, new Object[] {lV54Tipo_obligacionwwds_1_tftipooblcodigo, lV56Tipo_obligacionwwds_3_tftipoobldescrip, lV60Tipo_obligacionwwds_7_tfembargadescrip, Short.valueOf(AV45PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk19E2 = false ;
         A1161EmbargaSec = P019E2_A1161EmbargaSec[0] ;
         n1161EmbargaSec = P019E2_n1161EmbargaSec[0] ;
         A1164TipoOblCodigo = P019E2_A1164TipoOblCodigo[0] ;
         A1159TipoOblPaiCod = P019E2_A1159TipoOblPaiCod[0] ;
         A1162EmbargaDescrip = P019E2_A1162EmbargaDescrip[0] ;
         A1168TipoOblTotTipo = P019E2_A1168TipoOblTotTipo[0] ;
         A1167TipoOblAnti = P019E2_A1167TipoOblAnti[0] ;
         A1165TipoOblDescrip = P019E2_A1165TipoOblDescrip[0] ;
         A1163TipoOblSec = P019E2_A1163TipoOblSec[0] ;
         A1162EmbargaDescrip = P019E2_A1162EmbargaDescrip[0] ;
         AV28count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P019E2_A1164TipoOblCodigo[0], A1164TipoOblCodigo) == 0 ) )
         {
            brk19E2 = false ;
            A1163TipoOblSec = P019E2_A1163TipoOblSec[0] ;
            AV28count = (long)(AV28count+1) ;
            brk19E2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1164TipoOblCodigo)==0) )
         {
            AV23Option = A1164TipoOblCodigo ;
            AV24Options.add(AV23Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV28count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk19E2 )
         {
            brk19E2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADTIPOOBLDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV15TFTipoOblDescrip = AV35SearchTxt ;
      AV16TFTipoOblDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV54Tipo_obligacionwwds_1_tftipooblcodigo = AV12TFTipoOblCodigo ;
      AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels = AV13TFTipoOblCodigo_Sels ;
      AV56Tipo_obligacionwwds_3_tftipoobldescrip = AV15TFTipoOblDescrip ;
      AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels = AV16TFTipoOblDescrip_Sels ;
      AV58Tipo_obligacionwwds_5_tftipooblanti_sel = AV17TFTipoOblAnti_Sel ;
      AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels = AV19TFTipoOblTotTipo_Sels ;
      AV60Tipo_obligacionwwds_7_tfembargadescrip = AV47TFEmbargaDescrip ;
      AV61Tipo_obligacionwwds_8_tfembargadescrip_sels = AV48TFEmbargaDescrip_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1164TipoOblCodigo ,
                                           AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels ,
                                           A1165TipoOblDescrip ,
                                           AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels ,
                                           Byte.valueOf(A1168TipoOblTotTipo) ,
                                           AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels ,
                                           A1162EmbargaDescrip ,
                                           AV61Tipo_obligacionwwds_8_tfembargadescrip_sels ,
                                           Integer.valueOf(AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels.size()) ,
                                           AV54Tipo_obligacionwwds_1_tftipooblcodigo ,
                                           Integer.valueOf(AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels.size()) ,
                                           AV56Tipo_obligacionwwds_3_tftipoobldescrip ,
                                           Byte.valueOf(AV58Tipo_obligacionwwds_5_tftipooblanti_sel) ,
                                           Integer.valueOf(AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels.size()) ,
                                           Integer.valueOf(AV61Tipo_obligacionwwds_8_tfembargadescrip_sels.size()) ,
                                           AV60Tipo_obligacionwwds_7_tfembargadescrip ,
                                           Short.valueOf(AV45PaiCod) ,
                                           Boolean.valueOf(A1167TipoOblAnti) ,
                                           Short.valueOf(A1159TipoOblPaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.SHORT
                                           }
      });
      lV54Tipo_obligacionwwds_1_tftipooblcodigo = GXutil.padr( GXutil.rtrim( AV54Tipo_obligacionwwds_1_tftipooblcodigo), 20, "%") ;
      lV56Tipo_obligacionwwds_3_tftipoobldescrip = GXutil.concat( GXutil.rtrim( AV56Tipo_obligacionwwds_3_tftipoobldescrip), "%", "") ;
      lV60Tipo_obligacionwwds_7_tfembargadescrip = GXutil.concat( GXutil.rtrim( AV60Tipo_obligacionwwds_7_tfembargadescrip), "%", "") ;
      /* Using cursor P019E3 */
      pr_default.execute(1, new Object[] {lV54Tipo_obligacionwwds_1_tftipooblcodigo, lV56Tipo_obligacionwwds_3_tftipoobldescrip, lV60Tipo_obligacionwwds_7_tfembargadescrip, Short.valueOf(AV45PaiCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk19E4 = false ;
         A1161EmbargaSec = P019E3_A1161EmbargaSec[0] ;
         n1161EmbargaSec = P019E3_n1161EmbargaSec[0] ;
         A1165TipoOblDescrip = P019E3_A1165TipoOblDescrip[0] ;
         A1159TipoOblPaiCod = P019E3_A1159TipoOblPaiCod[0] ;
         A1162EmbargaDescrip = P019E3_A1162EmbargaDescrip[0] ;
         A1168TipoOblTotTipo = P019E3_A1168TipoOblTotTipo[0] ;
         A1167TipoOblAnti = P019E3_A1167TipoOblAnti[0] ;
         A1164TipoOblCodigo = P019E3_A1164TipoOblCodigo[0] ;
         A1163TipoOblSec = P019E3_A1163TipoOblSec[0] ;
         A1162EmbargaDescrip = P019E3_A1162EmbargaDescrip[0] ;
         AV28count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P019E3_A1165TipoOblDescrip[0], A1165TipoOblDescrip) == 0 ) )
         {
            brk19E4 = false ;
            A1163TipoOblSec = P019E3_A1163TipoOblSec[0] ;
            AV28count = (long)(AV28count+1) ;
            brk19E4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1165TipoOblDescrip)==0) )
         {
            AV23Option = A1165TipoOblDescrip ;
            AV24Options.add(AV23Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV28count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk19E4 )
         {
            brk19E4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADEMBARGADESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV47TFEmbargaDescrip = AV35SearchTxt ;
      AV48TFEmbargaDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV54Tipo_obligacionwwds_1_tftipooblcodigo = AV12TFTipoOblCodigo ;
      AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels = AV13TFTipoOblCodigo_Sels ;
      AV56Tipo_obligacionwwds_3_tftipoobldescrip = AV15TFTipoOblDescrip ;
      AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels = AV16TFTipoOblDescrip_Sels ;
      AV58Tipo_obligacionwwds_5_tftipooblanti_sel = AV17TFTipoOblAnti_Sel ;
      AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels = AV19TFTipoOblTotTipo_Sels ;
      AV60Tipo_obligacionwwds_7_tfembargadescrip = AV47TFEmbargaDescrip ;
      AV61Tipo_obligacionwwds_8_tfembargadescrip_sels = AV48TFEmbargaDescrip_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A1164TipoOblCodigo ,
                                           AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels ,
                                           A1165TipoOblDescrip ,
                                           AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels ,
                                           Byte.valueOf(A1168TipoOblTotTipo) ,
                                           AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels ,
                                           A1162EmbargaDescrip ,
                                           AV61Tipo_obligacionwwds_8_tfembargadescrip_sels ,
                                           Integer.valueOf(AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels.size()) ,
                                           AV54Tipo_obligacionwwds_1_tftipooblcodigo ,
                                           Integer.valueOf(AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels.size()) ,
                                           AV56Tipo_obligacionwwds_3_tftipoobldescrip ,
                                           Byte.valueOf(AV58Tipo_obligacionwwds_5_tftipooblanti_sel) ,
                                           Integer.valueOf(AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels.size()) ,
                                           Integer.valueOf(AV61Tipo_obligacionwwds_8_tfembargadescrip_sels.size()) ,
                                           AV60Tipo_obligacionwwds_7_tfembargadescrip ,
                                           Short.valueOf(AV45PaiCod) ,
                                           Boolean.valueOf(A1167TipoOblAnti) ,
                                           Short.valueOf(A1159TipoOblPaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.SHORT
                                           }
      });
      lV54Tipo_obligacionwwds_1_tftipooblcodigo = GXutil.padr( GXutil.rtrim( AV54Tipo_obligacionwwds_1_tftipooblcodigo), 20, "%") ;
      lV56Tipo_obligacionwwds_3_tftipoobldescrip = GXutil.concat( GXutil.rtrim( AV56Tipo_obligacionwwds_3_tftipoobldescrip), "%", "") ;
      lV60Tipo_obligacionwwds_7_tfembargadescrip = GXutil.concat( GXutil.rtrim( AV60Tipo_obligacionwwds_7_tfembargadescrip), "%", "") ;
      /* Using cursor P019E4 */
      pr_default.execute(2, new Object[] {lV54Tipo_obligacionwwds_1_tftipooblcodigo, lV56Tipo_obligacionwwds_3_tftipoobldescrip, lV60Tipo_obligacionwwds_7_tfembargadescrip, Short.valueOf(AV45PaiCod)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk19E6 = false ;
         A1161EmbargaSec = P019E4_A1161EmbargaSec[0] ;
         n1161EmbargaSec = P019E4_n1161EmbargaSec[0] ;
         A1159TipoOblPaiCod = P019E4_A1159TipoOblPaiCod[0] ;
         A1162EmbargaDescrip = P019E4_A1162EmbargaDescrip[0] ;
         A1168TipoOblTotTipo = P019E4_A1168TipoOblTotTipo[0] ;
         A1167TipoOblAnti = P019E4_A1167TipoOblAnti[0] ;
         A1165TipoOblDescrip = P019E4_A1165TipoOblDescrip[0] ;
         A1164TipoOblCodigo = P019E4_A1164TipoOblCodigo[0] ;
         A1163TipoOblSec = P019E4_A1163TipoOblSec[0] ;
         A1162EmbargaDescrip = P019E4_A1162EmbargaDescrip[0] ;
         AV28count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( P019E4_A1161EmbargaSec[0] == A1161EmbargaSec ) )
         {
            brk19E6 = false ;
            A1163TipoOblSec = P019E4_A1163TipoOblSec[0] ;
            AV28count = (long)(AV28count+1) ;
            brk19E6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A1162EmbargaDescrip)==0) )
         {
            AV23Option = A1162EmbargaDescrip ;
            AV22InsertIndex = 1 ;
            while ( ( AV22InsertIndex <= AV24Options.size() ) && ( GXutil.strcmp((String)AV24Options.elementAt(-1+AV22InsertIndex), AV23Option) < 0 ) )
            {
               AV22InsertIndex = (int)(AV22InsertIndex+1) ;
            }
            AV24Options.add(AV23Option, AV22InsertIndex);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV28count), "Z,ZZZ,ZZZ,ZZ9")), AV22InsertIndex);
         }
         if ( AV24Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk19E6 )
         {
            brk19E6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = tipo_obligacionwwgetfilterdata.this.AV37OptionsJson;
      this.aP4[0] = tipo_obligacionwwgetfilterdata.this.AV38OptionsDescJson;
      this.aP5[0] = tipo_obligacionwwgetfilterdata.this.AV39OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV37OptionsJson = "" ;
      AV38OptionsDescJson = "" ;
      AV39OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV24Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV29Session = httpContext.getWebSession();
      AV31GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV32GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFTipoOblCodigo = "" ;
      AV11TFTipoOblCodigo_SelsJson = "" ;
      AV13TFTipoOblCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFTipoOblDescrip = "" ;
      AV14TFTipoOblDescrip_SelsJson = "" ;
      AV16TFTipoOblDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV18TFTipoOblTotTipo_SelsJson = "" ;
      AV19TFTipoOblTotTipo_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV47TFEmbargaDescrip = "" ;
      AV46TFEmbargaDescrip_SelsJson = "" ;
      AV48TFEmbargaDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49MenuOpcCod = "" ;
      A1164TipoOblCodigo = "" ;
      AV54Tipo_obligacionwwds_1_tftipooblcodigo = "" ;
      AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV56Tipo_obligacionwwds_3_tftipoobldescrip = "" ;
      AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV60Tipo_obligacionwwds_7_tfembargadescrip = "" ;
      AV61Tipo_obligacionwwds_8_tfembargadescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV54Tipo_obligacionwwds_1_tftipooblcodigo = "" ;
      lV56Tipo_obligacionwwds_3_tftipoobldescrip = "" ;
      lV60Tipo_obligacionwwds_7_tfembargadescrip = "" ;
      A1165TipoOblDescrip = "" ;
      A1162EmbargaDescrip = "" ;
      P019E2_A1161EmbargaSec = new short[1] ;
      P019E2_n1161EmbargaSec = new boolean[] {false} ;
      P019E2_A1164TipoOblCodigo = new String[] {""} ;
      P019E2_A1159TipoOblPaiCod = new short[1] ;
      P019E2_A1162EmbargaDescrip = new String[] {""} ;
      P019E2_A1168TipoOblTotTipo = new byte[1] ;
      P019E2_A1167TipoOblAnti = new boolean[] {false} ;
      P019E2_A1165TipoOblDescrip = new String[] {""} ;
      P019E2_A1163TipoOblSec = new short[1] ;
      AV23Option = "" ;
      P019E3_A1161EmbargaSec = new short[1] ;
      P019E3_n1161EmbargaSec = new boolean[] {false} ;
      P019E3_A1165TipoOblDescrip = new String[] {""} ;
      P019E3_A1159TipoOblPaiCod = new short[1] ;
      P019E3_A1162EmbargaDescrip = new String[] {""} ;
      P019E3_A1168TipoOblTotTipo = new byte[1] ;
      P019E3_A1167TipoOblAnti = new boolean[] {false} ;
      P019E3_A1164TipoOblCodigo = new String[] {""} ;
      P019E3_A1163TipoOblSec = new short[1] ;
      P019E4_A1161EmbargaSec = new short[1] ;
      P019E4_n1161EmbargaSec = new boolean[] {false} ;
      P019E4_A1159TipoOblPaiCod = new short[1] ;
      P019E4_A1162EmbargaDescrip = new String[] {""} ;
      P019E4_A1168TipoOblTotTipo = new byte[1] ;
      P019E4_A1167TipoOblAnti = new boolean[] {false} ;
      P019E4_A1165TipoOblDescrip = new String[] {""} ;
      P019E4_A1164TipoOblCodigo = new String[] {""} ;
      P019E4_A1163TipoOblSec = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tipo_obligacionwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P019E2_A1161EmbargaSec, P019E2_n1161EmbargaSec, P019E2_A1164TipoOblCodigo, P019E2_A1159TipoOblPaiCod, P019E2_A1162EmbargaDescrip, P019E2_A1168TipoOblTotTipo, P019E2_A1167TipoOblAnti, P019E2_A1165TipoOblDescrip, P019E2_A1163TipoOblSec
            }
            , new Object[] {
            P019E3_A1161EmbargaSec, P019E3_n1161EmbargaSec, P019E3_A1165TipoOblDescrip, P019E3_A1159TipoOblPaiCod, P019E3_A1162EmbargaDescrip, P019E3_A1168TipoOblTotTipo, P019E3_A1167TipoOblAnti, P019E3_A1164TipoOblCodigo, P019E3_A1163TipoOblSec
            }
            , new Object[] {
            P019E4_A1161EmbargaSec, P019E4_n1161EmbargaSec, P019E4_A1159TipoOblPaiCod, P019E4_A1162EmbargaDescrip, P019E4_A1168TipoOblTotTipo, P019E4_A1167TipoOblAnti, P019E4_A1165TipoOblDescrip, P019E4_A1164TipoOblCodigo, P019E4_A1163TipoOblSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV17TFTipoOblAnti_Sel ;
   private byte AV58Tipo_obligacionwwds_5_tftipooblanti_sel ;
   private byte A1168TipoOblTotTipo ;
   private short AV41EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV45PaiCod ;
   private short A1159TipoOblPaiCod ;
   private short A1161EmbargaSec ;
   private short A1163TipoOblSec ;
   private short Gx_err ;
   private int AV42CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV52GXV1 ;
   private int AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels_size ;
   private int AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels_size ;
   private int AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels_size ;
   private int AV61Tipo_obligacionwwds_8_tfembargadescrip_sels_size ;
   private int AV22InsertIndex ;
   private long AV28count ;
   private String AV12TFTipoOblCodigo ;
   private String A1164TipoOblCodigo ;
   private String AV54Tipo_obligacionwwds_1_tftipooblcodigo ;
   private String scmdbuf ;
   private String lV54Tipo_obligacionwwds_1_tftipooblcodigo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A1167TipoOblAnti ;
   private boolean brk19E2 ;
   private boolean n1161EmbargaSec ;
   private boolean brk19E4 ;
   private boolean brk19E6 ;
   private String AV37OptionsJson ;
   private String AV38OptionsDescJson ;
   private String AV39OptionIndexesJson ;
   private String AV11TFTipoOblCodigo_SelsJson ;
   private String AV14TFTipoOblDescrip_SelsJson ;
   private String AV18TFTipoOblTotTipo_SelsJson ;
   private String AV46TFEmbargaDescrip_SelsJson ;
   private String AV34DDOName ;
   private String AV35SearchTxt ;
   private String AV36SearchTxtTo ;
   private String AV15TFTipoOblDescrip ;
   private String AV47TFEmbargaDescrip ;
   private String AV49MenuOpcCod ;
   private String AV56Tipo_obligacionwwds_3_tftipoobldescrip ;
   private String AV60Tipo_obligacionwwds_7_tfembargadescrip ;
   private String lV56Tipo_obligacionwwds_3_tftipoobldescrip ;
   private String lV60Tipo_obligacionwwds_7_tfembargadescrip ;
   private String A1165TipoOblDescrip ;
   private String A1162EmbargaDescrip ;
   private String AV23Option ;
   private GXSimpleCollection<Byte> AV19TFTipoOblTotTipo_Sels ;
   private GXSimpleCollection<Byte> AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels ;
   private com.genexus.webpanels.WebSession AV29Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P019E2_A1161EmbargaSec ;
   private boolean[] P019E2_n1161EmbargaSec ;
   private String[] P019E2_A1164TipoOblCodigo ;
   private short[] P019E2_A1159TipoOblPaiCod ;
   private String[] P019E2_A1162EmbargaDescrip ;
   private byte[] P019E2_A1168TipoOblTotTipo ;
   private boolean[] P019E2_A1167TipoOblAnti ;
   private String[] P019E2_A1165TipoOblDescrip ;
   private short[] P019E2_A1163TipoOblSec ;
   private short[] P019E3_A1161EmbargaSec ;
   private boolean[] P019E3_n1161EmbargaSec ;
   private String[] P019E3_A1165TipoOblDescrip ;
   private short[] P019E3_A1159TipoOblPaiCod ;
   private String[] P019E3_A1162EmbargaDescrip ;
   private byte[] P019E3_A1168TipoOblTotTipo ;
   private boolean[] P019E3_A1167TipoOblAnti ;
   private String[] P019E3_A1164TipoOblCodigo ;
   private short[] P019E3_A1163TipoOblSec ;
   private short[] P019E4_A1161EmbargaSec ;
   private boolean[] P019E4_n1161EmbargaSec ;
   private short[] P019E4_A1159TipoOblPaiCod ;
   private String[] P019E4_A1162EmbargaDescrip ;
   private byte[] P019E4_A1168TipoOblTotTipo ;
   private boolean[] P019E4_A1167TipoOblAnti ;
   private String[] P019E4_A1165TipoOblDescrip ;
   private String[] P019E4_A1164TipoOblCodigo ;
   private short[] P019E4_A1163TipoOblSec ;
   private GXSimpleCollection<String> AV13TFTipoOblCodigo_Sels ;
   private GXSimpleCollection<String> AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels ;
   private GXSimpleCollection<String> AV24Options ;
   private GXSimpleCollection<String> AV26OptionsDesc ;
   private GXSimpleCollection<String> AV27OptionIndexes ;
   private GXSimpleCollection<String> AV16TFTipoOblDescrip_Sels ;
   private GXSimpleCollection<String> AV48TFEmbargaDescrip_Sels ;
   private GXSimpleCollection<String> AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels ;
   private GXSimpleCollection<String> AV61Tipo_obligacionwwds_8_tfembargadescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV31GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV32GridStateFilterValue ;
}

final  class tipo_obligacionwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P019E2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1164TipoOblCodigo ,
                                          GXSimpleCollection<String> AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels ,
                                          String A1165TipoOblDescrip ,
                                          GXSimpleCollection<String> AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels ,
                                          byte A1168TipoOblTotTipo ,
                                          GXSimpleCollection<Byte> AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels ,
                                          String A1162EmbargaDescrip ,
                                          GXSimpleCollection<String> AV61Tipo_obligacionwwds_8_tfembargadescrip_sels ,
                                          int AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels_size ,
                                          String AV54Tipo_obligacionwwds_1_tftipooblcodigo ,
                                          int AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels_size ,
                                          String AV56Tipo_obligacionwwds_3_tftipoobldescrip ,
                                          byte AV58Tipo_obligacionwwds_5_tftipooblanti_sel ,
                                          int AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels_size ,
                                          int AV61Tipo_obligacionwwds_8_tfembargadescrip_sels_size ,
                                          String AV60Tipo_obligacionwwds_7_tfembargadescrip ,
                                          short AV45PaiCod ,
                                          boolean A1167TipoOblAnti ,
                                          short A1159TipoOblPaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[4];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.EmbargaSec, T1.TipoOblCodigo, T1.TipoOblPaiCod, T2.EmbargaDescrip, T1.TipoOblTotTipo, T1.TipoOblAnti, T1.TipoOblDescrip, T1.TipoOblSec FROM (tipo_obligacion" ;
      scmdbuf += " T1 LEFT JOIN embargabilidad T2 ON T2.EmbargaSec = T1.EmbargaSec)" ;
      if ( ( AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Tipo_obligacionwwds_1_tftipooblcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.TipoOblCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels, "T1.TipoOblCodigo IN (", ")")+")");
      }
      if ( ( AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV56Tipo_obligacionwwds_3_tftipoobldescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.TipoOblDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels, "T1.TipoOblDescrip IN (", ")")+")");
      }
      if ( AV58Tipo_obligacionwwds_5_tftipooblanti_sel == 1 )
      {
         addWhere(sWhereString, "(T1.TipoOblAnti = TRUE)");
      }
      if ( AV58Tipo_obligacionwwds_5_tftipooblanti_sel == 2 )
      {
         addWhere(sWhereString, "(T1.TipoOblAnti = FALSE)");
      }
      if ( AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels, "T1.TipoOblTotTipo IN (", ")")+")");
      }
      if ( ( AV61Tipo_obligacionwwds_8_tfembargadescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Tipo_obligacionwwds_7_tfembargadescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.EmbargaDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV61Tipo_obligacionwwds_8_tfembargadescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Tipo_obligacionwwds_8_tfembargadescrip_sels, "T2.EmbargaDescrip IN (", ")")+")");
      }
      if ( ! (0==AV45PaiCod) )
      {
         addWhere(sWhereString, "(T1.TipoOblPaiCod = ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.TipoOblCodigo" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P019E3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1164TipoOblCodigo ,
                                          GXSimpleCollection<String> AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels ,
                                          String A1165TipoOblDescrip ,
                                          GXSimpleCollection<String> AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels ,
                                          byte A1168TipoOblTotTipo ,
                                          GXSimpleCollection<Byte> AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels ,
                                          String A1162EmbargaDescrip ,
                                          GXSimpleCollection<String> AV61Tipo_obligacionwwds_8_tfembargadescrip_sels ,
                                          int AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels_size ,
                                          String AV54Tipo_obligacionwwds_1_tftipooblcodigo ,
                                          int AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels_size ,
                                          String AV56Tipo_obligacionwwds_3_tftipoobldescrip ,
                                          byte AV58Tipo_obligacionwwds_5_tftipooblanti_sel ,
                                          int AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels_size ,
                                          int AV61Tipo_obligacionwwds_8_tfembargadescrip_sels_size ,
                                          String AV60Tipo_obligacionwwds_7_tfembargadescrip ,
                                          short AV45PaiCod ,
                                          boolean A1167TipoOblAnti ,
                                          short A1159TipoOblPaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[4];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.EmbargaSec, T1.TipoOblDescrip, T1.TipoOblPaiCod, T2.EmbargaDescrip, T1.TipoOblTotTipo, T1.TipoOblAnti, T1.TipoOblCodigo, T1.TipoOblSec FROM (tipo_obligacion" ;
      scmdbuf += " T1 LEFT JOIN embargabilidad T2 ON T2.EmbargaSec = T1.EmbargaSec)" ;
      if ( ( AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Tipo_obligacionwwds_1_tftipooblcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.TipoOblCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels, "T1.TipoOblCodigo IN (", ")")+")");
      }
      if ( ( AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV56Tipo_obligacionwwds_3_tftipoobldescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.TipoOblDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels, "T1.TipoOblDescrip IN (", ")")+")");
      }
      if ( AV58Tipo_obligacionwwds_5_tftipooblanti_sel == 1 )
      {
         addWhere(sWhereString, "(T1.TipoOblAnti = TRUE)");
      }
      if ( AV58Tipo_obligacionwwds_5_tftipooblanti_sel == 2 )
      {
         addWhere(sWhereString, "(T1.TipoOblAnti = FALSE)");
      }
      if ( AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels, "T1.TipoOblTotTipo IN (", ")")+")");
      }
      if ( ( AV61Tipo_obligacionwwds_8_tfembargadescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Tipo_obligacionwwds_7_tfembargadescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.EmbargaDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV61Tipo_obligacionwwds_8_tfembargadescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Tipo_obligacionwwds_8_tfembargadescrip_sels, "T2.EmbargaDescrip IN (", ")")+")");
      }
      if ( ! (0==AV45PaiCod) )
      {
         addWhere(sWhereString, "(T1.TipoOblPaiCod = ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.TipoOblDescrip" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P019E4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1164TipoOblCodigo ,
                                          GXSimpleCollection<String> AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels ,
                                          String A1165TipoOblDescrip ,
                                          GXSimpleCollection<String> AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels ,
                                          byte A1168TipoOblTotTipo ,
                                          GXSimpleCollection<Byte> AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels ,
                                          String A1162EmbargaDescrip ,
                                          GXSimpleCollection<String> AV61Tipo_obligacionwwds_8_tfembargadescrip_sels ,
                                          int AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels_size ,
                                          String AV54Tipo_obligacionwwds_1_tftipooblcodigo ,
                                          int AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels_size ,
                                          String AV56Tipo_obligacionwwds_3_tftipoobldescrip ,
                                          byte AV58Tipo_obligacionwwds_5_tftipooblanti_sel ,
                                          int AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels_size ,
                                          int AV61Tipo_obligacionwwds_8_tfembargadescrip_sels_size ,
                                          String AV60Tipo_obligacionwwds_7_tfembargadescrip ,
                                          short AV45PaiCod ,
                                          boolean A1167TipoOblAnti ,
                                          short A1159TipoOblPaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[4];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT T1.EmbargaSec, T1.TipoOblPaiCod, T2.EmbargaDescrip, T1.TipoOblTotTipo, T1.TipoOblAnti, T1.TipoOblDescrip, T1.TipoOblCodigo, T1.TipoOblSec FROM (tipo_obligacion" ;
      scmdbuf += " T1 LEFT JOIN embargabilidad T2 ON T2.EmbargaSec = T1.EmbargaSec)" ;
      if ( ( AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Tipo_obligacionwwds_1_tftipooblcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.TipoOblCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int14[0] = (byte)(1) ;
      }
      if ( AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Tipo_obligacionwwds_2_tftipooblcodigo_sels, "T1.TipoOblCodigo IN (", ")")+")");
      }
      if ( ( AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV56Tipo_obligacionwwds_3_tftipoobldescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.TipoOblDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57Tipo_obligacionwwds_4_tftipoobldescrip_sels, "T1.TipoOblDescrip IN (", ")")+")");
      }
      if ( AV58Tipo_obligacionwwds_5_tftipooblanti_sel == 1 )
      {
         addWhere(sWhereString, "(T1.TipoOblAnti = TRUE)");
      }
      if ( AV58Tipo_obligacionwwds_5_tftipooblanti_sel == 2 )
      {
         addWhere(sWhereString, "(T1.TipoOblAnti = FALSE)");
      }
      if ( AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Tipo_obligacionwwds_6_tftipoobltottipo_sels, "T1.TipoOblTotTipo IN (", ")")+")");
      }
      if ( ( AV61Tipo_obligacionwwds_8_tfembargadescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Tipo_obligacionwwds_7_tfembargadescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.EmbargaDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV61Tipo_obligacionwwds_8_tfembargadescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Tipo_obligacionwwds_8_tfembargadescrip_sels, "T2.EmbargaDescrip IN (", ")")+")");
      }
      if ( ! (0==AV45PaiCod) )
      {
         addWhere(sWhereString, "(T1.TipoOblPaiCod = ?)");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.EmbargaSec" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P019E2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , ((Boolean) dynConstraints[17]).booleanValue() , ((Number) dynConstraints[18]).shortValue() );
            case 1 :
                  return conditional_P019E3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , ((Boolean) dynConstraints[17]).booleanValue() , ((Number) dynConstraints[18]).shortValue() );
            case 2 :
                  return conditional_P019E4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).byteValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , ((Boolean) dynConstraints[17]).booleanValue() , ((Number) dynConstraints[18]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P019E2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P019E3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P019E4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((byte[]) buf[5])[0] = rslt.getByte(5);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((short[]) buf[8])[0] = rslt.getShort(8);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((byte[]) buf[5])[0] = rslt.getByte(5);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((short[]) buf[8])[0] = rslt.getShort(8);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((byte[]) buf[4])[0] = rslt.getByte(4);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((short[]) buf[8])[0] = rslt.getShort(8);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[4], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[4], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[4], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 400);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 30);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               return;
      }
   }

}

