package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class tipodeconceptowwgetfilterdata extends GXProcedure
{
   public tipodeconceptowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipodeconceptowwgetfilterdata.class ), "" );
   }

   public tipodeconceptowwgetfilterdata( int remoteHandle ,
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
      tipodeconceptowwgetfilterdata.this.aP5 = new String[] {""};
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
      tipodeconceptowwgetfilterdata.this.AV41DDOName = aP0;
      tipodeconceptowwgetfilterdata.this.AV42SearchTxt = aP1;
      tipodeconceptowwgetfilterdata.this.AV43SearchTxtTo = aP2;
      tipodeconceptowwgetfilterdata.this.aP3 = aP3;
      tipodeconceptowwgetfilterdata.this.aP4 = aP4;
      tipodeconceptowwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV48EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      tipodeconceptowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV48EmpCod = GXt_int1 ;
      GXt_int3 = AV49CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      tipodeconceptowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV49CliCod = GXt_int3 ;
      AV31Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV33OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV34OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWTipoDeConcepto", GXv_boolean6) ;
      tipodeconceptowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV41DDOName), "DDO_TIPOCONDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADTIPOCONDESCRIPOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV41DDOName), "DDO_TIPOCONPALABRA") == 0 )
         {
            /* Execute user subroutine: 'LOADTIPOCONPALABRAOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV44OptionsJson = AV31Options.toJSonString(false) ;
      AV45OptionsDescJson = AV33OptionsDesc.toJSonString(false) ;
      AV46OptionIndexesJson = AV34OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV36Session.getValue("TipoDeConceptoWWGridState"), "") == 0 )
      {
         AV38GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "TipoDeConceptoWWGridState"), null, null);
      }
      else
      {
         AV38GridState.fromxml(AV36Session.getValue("TipoDeConceptoWWGridState"), null, null);
      }
      AV52GXV1 = 1 ;
      while ( AV52GXV1 <= AV38GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV39GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV38GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV52GXV1));
         if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONCOD_SEL") == 0 )
         {
            AV11TFTipoConCod_SelsJson = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV12TFTipoConCod_Sels.fromJSonString(AV11TFTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONDESCRIP") == 0 )
         {
            AV14TFTipoConDescrip = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONDESCRIP_SEL") == 0 )
         {
            AV13TFTipoConDescrip_SelsJson = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFTipoConDescrip_Sels.fromJSonString(AV13TFTipoConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTRANGODESDE") == 0 )
         {
            AV16TFTRangoDesde = (int)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV17TFTRangoDesde_To = (int)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTRANGOHASTA") == 0 )
         {
            AV18TFTRangoHasta = (int)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV19TFTRangoHasta_To = (int)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONORDEN") == 0 )
         {
            AV20TFTipoConOrden = (short)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV21TFTipoConOrden_To = (short)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONPALABRA") == 0 )
         {
            AV23TFTipoConPalabra = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONPALABRA_SEL") == 0 )
         {
            AV22TFTipoConPalabra_SelsJson = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV24TFTipoConPalabra_Sels.fromJSonString(AV22TFTipoConPalabra_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONTIPO_SEL") == 0 )
         {
            AV25TFTipoConTipo_SelsJson = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV26TFTipoConTipo_Sels.fromJSonString(AV25TFTipoConTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTIPOCONPAI") == 0 )
         {
            AV27TFTipoConPai = (short)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV28TFTipoConPai_To = (short)(GXutil.lval( AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV47MenuOpcCod = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV52GXV1 = (int)(AV52GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADTIPOCONDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV14TFTipoConDescrip = AV42SearchTxt ;
      AV15TFTipoConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV54Tipodeconceptowwds_1_tftipoconcod_sels = AV12TFTipoConCod_Sels ;
      AV55Tipodeconceptowwds_2_tftipocondescrip = AV14TFTipoConDescrip ;
      AV56Tipodeconceptowwds_3_tftipocondescrip_sels = AV15TFTipoConDescrip_Sels ;
      AV57Tipodeconceptowwds_4_tftrangodesde = AV16TFTRangoDesde ;
      AV58Tipodeconceptowwds_5_tftrangodesde_to = AV17TFTRangoDesde_To ;
      AV59Tipodeconceptowwds_6_tftrangohasta = AV18TFTRangoHasta ;
      AV60Tipodeconceptowwds_7_tftrangohasta_to = AV19TFTRangoHasta_To ;
      AV61Tipodeconceptowwds_8_tftipoconorden = AV20TFTipoConOrden ;
      AV62Tipodeconceptowwds_9_tftipoconorden_to = AV21TFTipoConOrden_To ;
      AV63Tipodeconceptowwds_10_tftipoconpalabra = AV23TFTipoConPalabra ;
      AV64Tipodeconceptowwds_11_tftipoconpalabra_sels = AV24TFTipoConPalabra_Sels ;
      AV65Tipodeconceptowwds_12_tftipocontipo_sels = AV26TFTipoConTipo_Sels ;
      AV66Tipodeconceptowwds_13_tftipoconpai = AV27TFTipoConPai ;
      AV67Tipodeconceptowwds_14_tftipoconpai_to = AV28TFTipoConPai_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A37TipoConCod ,
                                           AV54Tipodeconceptowwds_1_tftipoconcod_sels ,
                                           A370TipoConDescrip ,
                                           AV56Tipodeconceptowwds_3_tftipocondescrip_sels ,
                                           A2102TipoConPalabra ,
                                           AV64Tipodeconceptowwds_11_tftipoconpalabra_sels ,
                                           A2157TipoConTipo ,
                                           AV65Tipodeconceptowwds_12_tftipocontipo_sels ,
                                           Integer.valueOf(AV54Tipodeconceptowwds_1_tftipoconcod_sels.size()) ,
                                           Integer.valueOf(AV56Tipodeconceptowwds_3_tftipocondescrip_sels.size()) ,
                                           AV55Tipodeconceptowwds_2_tftipocondescrip ,
                                           Integer.valueOf(AV57Tipodeconceptowwds_4_tftrangodesde) ,
                                           Integer.valueOf(AV58Tipodeconceptowwds_5_tftrangodesde_to) ,
                                           Integer.valueOf(AV59Tipodeconceptowwds_6_tftrangohasta) ,
                                           Integer.valueOf(AV60Tipodeconceptowwds_7_tftrangohasta_to) ,
                                           Short.valueOf(AV61Tipodeconceptowwds_8_tftipoconorden) ,
                                           Short.valueOf(AV62Tipodeconceptowwds_9_tftipoconorden_to) ,
                                           Integer.valueOf(AV64Tipodeconceptowwds_11_tftipoconpalabra_sels.size()) ,
                                           AV63Tipodeconceptowwds_10_tftipoconpalabra ,
                                           Integer.valueOf(AV65Tipodeconceptowwds_12_tftipocontipo_sels.size()) ,
                                           Short.valueOf(AV66Tipodeconceptowwds_13_tftipoconpai) ,
                                           Short.valueOf(AV67Tipodeconceptowwds_14_tftipoconpai_to) ,
                                           Integer.valueOf(A377TRangoDesde) ,
                                           Integer.valueOf(A378TRangoHasta) ,
                                           Short.valueOf(A384TipoConOrden) ,
                                           Short.valueOf(A2120TipoConPai) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV55Tipodeconceptowwds_2_tftipocondescrip = GXutil.concat( GXutil.rtrim( AV55Tipodeconceptowwds_2_tftipocondescrip), "%", "") ;
      lV63Tipodeconceptowwds_10_tftipoconpalabra = GXutil.padr( GXutil.rtrim( AV63Tipodeconceptowwds_10_tftipoconpalabra), 20, "%") ;
      /* Using cursor P02CU2 */
      pr_default.execute(0, new Object[] {lV55Tipodeconceptowwds_2_tftipocondescrip, Integer.valueOf(AV57Tipodeconceptowwds_4_tftrangodesde), Integer.valueOf(AV58Tipodeconceptowwds_5_tftrangodesde_to), Integer.valueOf(AV59Tipodeconceptowwds_6_tftrangohasta), Integer.valueOf(AV60Tipodeconceptowwds_7_tftrangohasta_to), Short.valueOf(AV61Tipodeconceptowwds_8_tftipoconorden), Short.valueOf(AV62Tipodeconceptowwds_9_tftipoconorden_to), lV63Tipodeconceptowwds_10_tftipoconpalabra, Short.valueOf(AV66Tipodeconceptowwds_13_tftipoconpai), Short.valueOf(AV67Tipodeconceptowwds_14_tftipoconpai_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk2CU2 = false ;
         A370TipoConDescrip = P02CU2_A370TipoConDescrip[0] ;
         A2120TipoConPai = P02CU2_A2120TipoConPai[0] ;
         A2157TipoConTipo = P02CU2_A2157TipoConTipo[0] ;
         A2102TipoConPalabra = P02CU2_A2102TipoConPalabra[0] ;
         A384TipoConOrden = P02CU2_A384TipoConOrden[0] ;
         A378TRangoHasta = P02CU2_A378TRangoHasta[0] ;
         A377TRangoDesde = P02CU2_A377TRangoDesde[0] ;
         A37TipoConCod = P02CU2_A37TipoConCod[0] ;
         AV35count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P02CU2_A370TipoConDescrip[0], A370TipoConDescrip) == 0 ) )
         {
            brk2CU2 = false ;
            A37TipoConCod = P02CU2_A37TipoConCod[0] ;
            AV35count = (long)(AV35count+1) ;
            brk2CU2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A370TipoConDescrip)==0) )
         {
            AV30Option = A370TipoConDescrip ;
            AV31Options.add(AV30Option, 0);
            AV34OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV35count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV31Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2CU2 )
         {
            brk2CU2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADTIPOCONPALABRAOPTIONS' Routine */
      returnInSub = false ;
      AV23TFTipoConPalabra = AV42SearchTxt ;
      AV24TFTipoConPalabra_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV54Tipodeconceptowwds_1_tftipoconcod_sels = AV12TFTipoConCod_Sels ;
      AV55Tipodeconceptowwds_2_tftipocondescrip = AV14TFTipoConDescrip ;
      AV56Tipodeconceptowwds_3_tftipocondescrip_sels = AV15TFTipoConDescrip_Sels ;
      AV57Tipodeconceptowwds_4_tftrangodesde = AV16TFTRangoDesde ;
      AV58Tipodeconceptowwds_5_tftrangodesde_to = AV17TFTRangoDesde_To ;
      AV59Tipodeconceptowwds_6_tftrangohasta = AV18TFTRangoHasta ;
      AV60Tipodeconceptowwds_7_tftrangohasta_to = AV19TFTRangoHasta_To ;
      AV61Tipodeconceptowwds_8_tftipoconorden = AV20TFTipoConOrden ;
      AV62Tipodeconceptowwds_9_tftipoconorden_to = AV21TFTipoConOrden_To ;
      AV63Tipodeconceptowwds_10_tftipoconpalabra = AV23TFTipoConPalabra ;
      AV64Tipodeconceptowwds_11_tftipoconpalabra_sels = AV24TFTipoConPalabra_Sels ;
      AV65Tipodeconceptowwds_12_tftipocontipo_sels = AV26TFTipoConTipo_Sels ;
      AV66Tipodeconceptowwds_13_tftipoconpai = AV27TFTipoConPai ;
      AV67Tipodeconceptowwds_14_tftipoconpai_to = AV28TFTipoConPai_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A37TipoConCod ,
                                           AV54Tipodeconceptowwds_1_tftipoconcod_sels ,
                                           A370TipoConDescrip ,
                                           AV56Tipodeconceptowwds_3_tftipocondescrip_sels ,
                                           A2102TipoConPalabra ,
                                           AV64Tipodeconceptowwds_11_tftipoconpalabra_sels ,
                                           A2157TipoConTipo ,
                                           AV65Tipodeconceptowwds_12_tftipocontipo_sels ,
                                           Integer.valueOf(AV54Tipodeconceptowwds_1_tftipoconcod_sels.size()) ,
                                           Integer.valueOf(AV56Tipodeconceptowwds_3_tftipocondescrip_sels.size()) ,
                                           AV55Tipodeconceptowwds_2_tftipocondescrip ,
                                           Integer.valueOf(AV57Tipodeconceptowwds_4_tftrangodesde) ,
                                           Integer.valueOf(AV58Tipodeconceptowwds_5_tftrangodesde_to) ,
                                           Integer.valueOf(AV59Tipodeconceptowwds_6_tftrangohasta) ,
                                           Integer.valueOf(AV60Tipodeconceptowwds_7_tftrangohasta_to) ,
                                           Short.valueOf(AV61Tipodeconceptowwds_8_tftipoconorden) ,
                                           Short.valueOf(AV62Tipodeconceptowwds_9_tftipoconorden_to) ,
                                           Integer.valueOf(AV64Tipodeconceptowwds_11_tftipoconpalabra_sels.size()) ,
                                           AV63Tipodeconceptowwds_10_tftipoconpalabra ,
                                           Integer.valueOf(AV65Tipodeconceptowwds_12_tftipocontipo_sels.size()) ,
                                           Short.valueOf(AV66Tipodeconceptowwds_13_tftipoconpai) ,
                                           Short.valueOf(AV67Tipodeconceptowwds_14_tftipoconpai_to) ,
                                           Integer.valueOf(A377TRangoDesde) ,
                                           Integer.valueOf(A378TRangoHasta) ,
                                           Short.valueOf(A384TipoConOrden) ,
                                           Short.valueOf(A2120TipoConPai) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV55Tipodeconceptowwds_2_tftipocondescrip = GXutil.concat( GXutil.rtrim( AV55Tipodeconceptowwds_2_tftipocondescrip), "%", "") ;
      lV63Tipodeconceptowwds_10_tftipoconpalabra = GXutil.padr( GXutil.rtrim( AV63Tipodeconceptowwds_10_tftipoconpalabra), 20, "%") ;
      /* Using cursor P02CU3 */
      pr_default.execute(1, new Object[] {lV55Tipodeconceptowwds_2_tftipocondescrip, Integer.valueOf(AV57Tipodeconceptowwds_4_tftrangodesde), Integer.valueOf(AV58Tipodeconceptowwds_5_tftrangodesde_to), Integer.valueOf(AV59Tipodeconceptowwds_6_tftrangohasta), Integer.valueOf(AV60Tipodeconceptowwds_7_tftrangohasta_to), Short.valueOf(AV61Tipodeconceptowwds_8_tftipoconorden), Short.valueOf(AV62Tipodeconceptowwds_9_tftipoconorden_to), lV63Tipodeconceptowwds_10_tftipoconpalabra, Short.valueOf(AV66Tipodeconceptowwds_13_tftipoconpai), Short.valueOf(AV67Tipodeconceptowwds_14_tftipoconpai_to)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk2CU4 = false ;
         A2102TipoConPalabra = P02CU3_A2102TipoConPalabra[0] ;
         A2120TipoConPai = P02CU3_A2120TipoConPai[0] ;
         A2157TipoConTipo = P02CU3_A2157TipoConTipo[0] ;
         A384TipoConOrden = P02CU3_A384TipoConOrden[0] ;
         A378TRangoHasta = P02CU3_A378TRangoHasta[0] ;
         A377TRangoDesde = P02CU3_A377TRangoDesde[0] ;
         A370TipoConDescrip = P02CU3_A370TipoConDescrip[0] ;
         A37TipoConCod = P02CU3_A37TipoConCod[0] ;
         AV35count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P02CU3_A2102TipoConPalabra[0], A2102TipoConPalabra) == 0 ) )
         {
            brk2CU4 = false ;
            A37TipoConCod = P02CU3_A37TipoConCod[0] ;
            AV35count = (long)(AV35count+1) ;
            brk2CU4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A2102TipoConPalabra)==0) )
         {
            AV30Option = A2102TipoConPalabra ;
            AV31Options.add(AV30Option, 0);
            AV34OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV35count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV31Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2CU4 )
         {
            brk2CU4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = tipodeconceptowwgetfilterdata.this.AV44OptionsJson;
      this.aP4[0] = tipodeconceptowwgetfilterdata.this.AV45OptionsDescJson;
      this.aP5[0] = tipodeconceptowwgetfilterdata.this.AV46OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV44OptionsJson = "" ;
      AV45OptionsDescJson = "" ;
      AV46OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV31Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV33OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV34OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV36Session = httpContext.getWebSession();
      AV38GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV39GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV11TFTipoConCod_SelsJson = "" ;
      AV12TFTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14TFTipoConDescrip = "" ;
      AV13TFTipoConDescrip_SelsJson = "" ;
      AV15TFTipoConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23TFTipoConPalabra = "" ;
      AV22TFTipoConPalabra_SelsJson = "" ;
      AV24TFTipoConPalabra_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25TFTipoConTipo_SelsJson = "" ;
      AV26TFTipoConTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV47MenuOpcCod = "" ;
      A370TipoConDescrip = "" ;
      AV54Tipodeconceptowwds_1_tftipoconcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55Tipodeconceptowwds_2_tftipocondescrip = "" ;
      AV56Tipodeconceptowwds_3_tftipocondescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV63Tipodeconceptowwds_10_tftipoconpalabra = "" ;
      AV64Tipodeconceptowwds_11_tftipoconpalabra_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65Tipodeconceptowwds_12_tftipocontipo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV55Tipodeconceptowwds_2_tftipocondescrip = "" ;
      lV63Tipodeconceptowwds_10_tftipoconpalabra = "" ;
      A37TipoConCod = "" ;
      A2102TipoConPalabra = "" ;
      A2157TipoConTipo = "" ;
      P02CU2_A370TipoConDescrip = new String[] {""} ;
      P02CU2_A2120TipoConPai = new short[1] ;
      P02CU2_A2157TipoConTipo = new String[] {""} ;
      P02CU2_A2102TipoConPalabra = new String[] {""} ;
      P02CU2_A384TipoConOrden = new short[1] ;
      P02CU2_A378TRangoHasta = new int[1] ;
      P02CU2_A377TRangoDesde = new int[1] ;
      P02CU2_A37TipoConCod = new String[] {""} ;
      AV30Option = "" ;
      P02CU3_A2102TipoConPalabra = new String[] {""} ;
      P02CU3_A2120TipoConPai = new short[1] ;
      P02CU3_A2157TipoConTipo = new String[] {""} ;
      P02CU3_A384TipoConOrden = new short[1] ;
      P02CU3_A378TRangoHasta = new int[1] ;
      P02CU3_A377TRangoDesde = new int[1] ;
      P02CU3_A370TipoConDescrip = new String[] {""} ;
      P02CU3_A37TipoConCod = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tipodeconceptowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P02CU2_A370TipoConDescrip, P02CU2_A2120TipoConPai, P02CU2_A2157TipoConTipo, P02CU2_A2102TipoConPalabra, P02CU2_A384TipoConOrden, P02CU2_A378TRangoHasta, P02CU2_A377TRangoDesde, P02CU2_A37TipoConCod
            }
            , new Object[] {
            P02CU3_A2102TipoConPalabra, P02CU3_A2120TipoConPai, P02CU3_A2157TipoConTipo, P02CU3_A384TipoConOrden, P02CU3_A378TRangoHasta, P02CU3_A377TRangoDesde, P02CU3_A370TipoConDescrip, P02CU3_A37TipoConCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV48EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV20TFTipoConOrden ;
   private short AV21TFTipoConOrden_To ;
   private short AV27TFTipoConPai ;
   private short AV28TFTipoConPai_To ;
   private short AV61Tipodeconceptowwds_8_tftipoconorden ;
   private short AV62Tipodeconceptowwds_9_tftipoconorden_to ;
   private short AV66Tipodeconceptowwds_13_tftipoconpai ;
   private short AV67Tipodeconceptowwds_14_tftipoconpai_to ;
   private short A384TipoConOrden ;
   private short A2120TipoConPai ;
   private short Gx_err ;
   private int AV49CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV52GXV1 ;
   private int AV16TFTRangoDesde ;
   private int AV17TFTRangoDesde_To ;
   private int AV18TFTRangoHasta ;
   private int AV19TFTRangoHasta_To ;
   private int AV57Tipodeconceptowwds_4_tftrangodesde ;
   private int AV58Tipodeconceptowwds_5_tftrangodesde_to ;
   private int AV59Tipodeconceptowwds_6_tftrangohasta ;
   private int AV60Tipodeconceptowwds_7_tftrangohasta_to ;
   private int AV54Tipodeconceptowwds_1_tftipoconcod_sels_size ;
   private int AV56Tipodeconceptowwds_3_tftipocondescrip_sels_size ;
   private int AV64Tipodeconceptowwds_11_tftipoconpalabra_sels_size ;
   private int AV65Tipodeconceptowwds_12_tftipocontipo_sels_size ;
   private int A377TRangoDesde ;
   private int A378TRangoHasta ;
   private long AV35count ;
   private String AV23TFTipoConPalabra ;
   private String AV63Tipodeconceptowwds_10_tftipoconpalabra ;
   private String scmdbuf ;
   private String lV63Tipodeconceptowwds_10_tftipoconpalabra ;
   private String A37TipoConCod ;
   private String A2102TipoConPalabra ;
   private String A2157TipoConTipo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk2CU2 ;
   private boolean brk2CU4 ;
   private String AV44OptionsJson ;
   private String AV45OptionsDescJson ;
   private String AV46OptionIndexesJson ;
   private String AV11TFTipoConCod_SelsJson ;
   private String AV13TFTipoConDescrip_SelsJson ;
   private String AV22TFTipoConPalabra_SelsJson ;
   private String AV25TFTipoConTipo_SelsJson ;
   private String AV41DDOName ;
   private String AV42SearchTxt ;
   private String AV43SearchTxtTo ;
   private String AV14TFTipoConDescrip ;
   private String AV47MenuOpcCod ;
   private String A370TipoConDescrip ;
   private String AV55Tipodeconceptowwds_2_tftipocondescrip ;
   private String lV55Tipodeconceptowwds_2_tftipocondescrip ;
   private String AV30Option ;
   private com.genexus.webpanels.WebSession AV36Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P02CU2_A370TipoConDescrip ;
   private short[] P02CU2_A2120TipoConPai ;
   private String[] P02CU2_A2157TipoConTipo ;
   private String[] P02CU2_A2102TipoConPalabra ;
   private short[] P02CU2_A384TipoConOrden ;
   private int[] P02CU2_A378TRangoHasta ;
   private int[] P02CU2_A377TRangoDesde ;
   private String[] P02CU2_A37TipoConCod ;
   private String[] P02CU3_A2102TipoConPalabra ;
   private short[] P02CU3_A2120TipoConPai ;
   private String[] P02CU3_A2157TipoConTipo ;
   private short[] P02CU3_A384TipoConOrden ;
   private int[] P02CU3_A378TRangoHasta ;
   private int[] P02CU3_A377TRangoDesde ;
   private String[] P02CU3_A370TipoConDescrip ;
   private String[] P02CU3_A37TipoConCod ;
   private GXSimpleCollection<String> AV12TFTipoConCod_Sels ;
   private GXSimpleCollection<String> AV24TFTipoConPalabra_Sels ;
   private GXSimpleCollection<String> AV26TFTipoConTipo_Sels ;
   private GXSimpleCollection<String> AV54Tipodeconceptowwds_1_tftipoconcod_sels ;
   private GXSimpleCollection<String> AV64Tipodeconceptowwds_11_tftipoconpalabra_sels ;
   private GXSimpleCollection<String> AV65Tipodeconceptowwds_12_tftipocontipo_sels ;
   private GXSimpleCollection<String> AV31Options ;
   private GXSimpleCollection<String> AV33OptionsDesc ;
   private GXSimpleCollection<String> AV34OptionIndexes ;
   private GXSimpleCollection<String> AV15TFTipoConDescrip_Sels ;
   private GXSimpleCollection<String> AV56Tipodeconceptowwds_3_tftipocondescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV38GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV39GridStateFilterValue ;
}

final  class tipodeconceptowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02CU2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV54Tipodeconceptowwds_1_tftipoconcod_sels ,
                                          String A370TipoConDescrip ,
                                          GXSimpleCollection<String> AV56Tipodeconceptowwds_3_tftipocondescrip_sels ,
                                          String A2102TipoConPalabra ,
                                          GXSimpleCollection<String> AV64Tipodeconceptowwds_11_tftipoconpalabra_sels ,
                                          String A2157TipoConTipo ,
                                          GXSimpleCollection<String> AV65Tipodeconceptowwds_12_tftipocontipo_sels ,
                                          int AV54Tipodeconceptowwds_1_tftipoconcod_sels_size ,
                                          int AV56Tipodeconceptowwds_3_tftipocondescrip_sels_size ,
                                          String AV55Tipodeconceptowwds_2_tftipocondescrip ,
                                          int AV57Tipodeconceptowwds_4_tftrangodesde ,
                                          int AV58Tipodeconceptowwds_5_tftrangodesde_to ,
                                          int AV59Tipodeconceptowwds_6_tftrangohasta ,
                                          int AV60Tipodeconceptowwds_7_tftrangohasta_to ,
                                          short AV61Tipodeconceptowwds_8_tftipoconorden ,
                                          short AV62Tipodeconceptowwds_9_tftipoconorden_to ,
                                          int AV64Tipodeconceptowwds_11_tftipoconpalabra_sels_size ,
                                          String AV63Tipodeconceptowwds_10_tftipoconpalabra ,
                                          int AV65Tipodeconceptowwds_12_tftipocontipo_sels_size ,
                                          short AV66Tipodeconceptowwds_13_tftipoconpai ,
                                          short AV67Tipodeconceptowwds_14_tftipoconpai_to ,
                                          int A377TRangoDesde ,
                                          int A378TRangoHasta ,
                                          short A384TipoConOrden ,
                                          short A2120TipoConPai )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[10];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT TipoConDescrip, TipoConPai, TipoConTipo, TipoConPalabra, TipoConOrden, TRangoHasta, TRangoDesde, TipoConCod FROM TipoDeConcepto" ;
      if ( AV54Tipodeconceptowwds_1_tftipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Tipodeconceptowwds_1_tftipoconcod_sels, "TipoConCod IN (", ")")+")");
      }
      if ( ( AV56Tipodeconceptowwds_3_tftipocondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Tipodeconceptowwds_2_tftipocondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TipoConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV56Tipodeconceptowwds_3_tftipocondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Tipodeconceptowwds_3_tftipocondescrip_sels, "TipoConDescrip IN (", ")")+")");
      }
      if ( ! (0==AV57Tipodeconceptowwds_4_tftrangodesde) )
      {
         addWhere(sWhereString, "(TRangoDesde >= ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ! (0==AV58Tipodeconceptowwds_5_tftrangodesde_to) )
      {
         addWhere(sWhereString, "(TRangoDesde <= ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ! (0==AV59Tipodeconceptowwds_6_tftrangohasta) )
      {
         addWhere(sWhereString, "(TRangoHasta >= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! (0==AV60Tipodeconceptowwds_7_tftrangohasta_to) )
      {
         addWhere(sWhereString, "(TRangoHasta <= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! (0==AV61Tipodeconceptowwds_8_tftipoconorden) )
      {
         addWhere(sWhereString, "(TipoConOrden >= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! (0==AV62Tipodeconceptowwds_9_tftipoconorden_to) )
      {
         addWhere(sWhereString, "(TipoConOrden <= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ( AV64Tipodeconceptowwds_11_tftipoconpalabra_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV63Tipodeconceptowwds_10_tftipoconpalabra)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TipoConPalabra) like LOWER(?))");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( AV64Tipodeconceptowwds_11_tftipoconpalabra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Tipodeconceptowwds_11_tftipoconpalabra_sels, "TipoConPalabra IN (", ")")+")");
      }
      if ( AV65Tipodeconceptowwds_12_tftipocontipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Tipodeconceptowwds_12_tftipocontipo_sels, "TipoConTipo IN (", ")")+")");
      }
      if ( ! (0==AV66Tipodeconceptowwds_13_tftipoconpai) )
      {
         addWhere(sWhereString, "(TipoConPai >= ?)");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( ! (0==AV67Tipodeconceptowwds_14_tftipoconpai_to) )
      {
         addWhere(sWhereString, "(TipoConPai <= ?)");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY TipoConDescrip" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P02CU3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A37TipoConCod ,
                                          GXSimpleCollection<String> AV54Tipodeconceptowwds_1_tftipoconcod_sels ,
                                          String A370TipoConDescrip ,
                                          GXSimpleCollection<String> AV56Tipodeconceptowwds_3_tftipocondescrip_sels ,
                                          String A2102TipoConPalabra ,
                                          GXSimpleCollection<String> AV64Tipodeconceptowwds_11_tftipoconpalabra_sels ,
                                          String A2157TipoConTipo ,
                                          GXSimpleCollection<String> AV65Tipodeconceptowwds_12_tftipocontipo_sels ,
                                          int AV54Tipodeconceptowwds_1_tftipoconcod_sels_size ,
                                          int AV56Tipodeconceptowwds_3_tftipocondescrip_sels_size ,
                                          String AV55Tipodeconceptowwds_2_tftipocondescrip ,
                                          int AV57Tipodeconceptowwds_4_tftrangodesde ,
                                          int AV58Tipodeconceptowwds_5_tftrangodesde_to ,
                                          int AV59Tipodeconceptowwds_6_tftrangohasta ,
                                          int AV60Tipodeconceptowwds_7_tftrangohasta_to ,
                                          short AV61Tipodeconceptowwds_8_tftipoconorden ,
                                          short AV62Tipodeconceptowwds_9_tftipoconorden_to ,
                                          int AV64Tipodeconceptowwds_11_tftipoconpalabra_sels_size ,
                                          String AV63Tipodeconceptowwds_10_tftipoconpalabra ,
                                          int AV65Tipodeconceptowwds_12_tftipocontipo_sels_size ,
                                          short AV66Tipodeconceptowwds_13_tftipoconpai ,
                                          short AV67Tipodeconceptowwds_14_tftipoconpai_to ,
                                          int A377TRangoDesde ,
                                          int A378TRangoHasta ,
                                          short A384TipoConOrden ,
                                          short A2120TipoConPai )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[10];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT TipoConPalabra, TipoConPai, TipoConTipo, TipoConOrden, TRangoHasta, TRangoDesde, TipoConDescrip, TipoConCod FROM TipoDeConcepto" ;
      if ( AV54Tipodeconceptowwds_1_tftipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Tipodeconceptowwds_1_tftipoconcod_sels, "TipoConCod IN (", ")")+")");
      }
      if ( ( AV56Tipodeconceptowwds_3_tftipocondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Tipodeconceptowwds_2_tftipocondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TipoConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV56Tipodeconceptowwds_3_tftipocondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Tipodeconceptowwds_3_tftipocondescrip_sels, "TipoConDescrip IN (", ")")+")");
      }
      if ( ! (0==AV57Tipodeconceptowwds_4_tftrangodesde) )
      {
         addWhere(sWhereString, "(TRangoDesde >= ?)");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( ! (0==AV58Tipodeconceptowwds_5_tftrangodesde_to) )
      {
         addWhere(sWhereString, "(TRangoDesde <= ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( ! (0==AV59Tipodeconceptowwds_6_tftrangohasta) )
      {
         addWhere(sWhereString, "(TRangoHasta >= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ! (0==AV60Tipodeconceptowwds_7_tftrangohasta_to) )
      {
         addWhere(sWhereString, "(TRangoHasta <= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! (0==AV61Tipodeconceptowwds_8_tftipoconorden) )
      {
         addWhere(sWhereString, "(TipoConOrden >= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! (0==AV62Tipodeconceptowwds_9_tftipoconorden_to) )
      {
         addWhere(sWhereString, "(TipoConOrden <= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ( AV64Tipodeconceptowwds_11_tftipoconpalabra_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV63Tipodeconceptowwds_10_tftipoconpalabra)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TipoConPalabra) like LOWER(?))");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( AV64Tipodeconceptowwds_11_tftipoconpalabra_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Tipodeconceptowwds_11_tftipoconpalabra_sels, "TipoConPalabra IN (", ")")+")");
      }
      if ( AV65Tipodeconceptowwds_12_tftipocontipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Tipodeconceptowwds_12_tftipocontipo_sels, "TipoConTipo IN (", ")")+")");
      }
      if ( ! (0==AV66Tipodeconceptowwds_13_tftipoconpai) )
      {
         addWhere(sWhereString, "(TipoConPai >= ?)");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( ! (0==AV67Tipodeconceptowwds_14_tftipoconpai_to) )
      {
         addWhere(sWhereString, "(TipoConPai <= ?)");
      }
      else
      {
         GXv_int11[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY TipoConPalabra" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
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
                  return conditional_P02CU2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).shortValue() );
            case 1 :
                  return conditional_P02CU3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).shortValue() , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).shortValue() , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).shortValue() , ((Number) dynConstraints[25]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02CU2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02CU3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
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
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[13]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[14]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[18]).shortValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[19]).shortValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[13]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[14]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[16]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[18]).shortValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[19]).shortValue());
               }
               return;
      }
   }

}

