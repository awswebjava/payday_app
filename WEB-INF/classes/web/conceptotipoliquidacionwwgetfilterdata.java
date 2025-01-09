package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptotipoliquidacionwwgetfilterdata extends GXProcedure
{
   public conceptotipoliquidacionwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptotipoliquidacionwwgetfilterdata.class ), "" );
   }

   public conceptotipoliquidacionwwgetfilterdata( int remoteHandle ,
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
      conceptotipoliquidacionwwgetfilterdata.this.aP5 = new String[] {""};
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
      conceptotipoliquidacionwwgetfilterdata.this.AV39DDOName = aP0;
      conceptotipoliquidacionwwgetfilterdata.this.AV40SearchTxt = aP1;
      conceptotipoliquidacionwwgetfilterdata.this.AV41SearchTxtTo = aP2;
      conceptotipoliquidacionwwgetfilterdata.this.aP3 = aP3;
      conceptotipoliquidacionwwgetfilterdata.this.aP4 = aP4;
      conceptotipoliquidacionwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV46EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      conceptotipoliquidacionwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV46EmpCod = GXt_int1 ;
      GXt_int3 = AV47CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      conceptotipoliquidacionwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV47CliCod = GXt_int3 ;
      AV29Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV31OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV32OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptoTipoLiquidacion", GXv_boolean6) ;
      conceptotipoliquidacionwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV39DDOName), "DDO_CONCODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADCONCODIGOOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV39DDOName), "DDO_TLIQCOD") == 0 )
         {
            /* Execute user subroutine: 'LOADTLIQCODOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV39DDOName), "DDO_CONTLCONDICION") == 0 )
         {
            /* Execute user subroutine: 'LOADCONTLCONDICIONOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV39DDOName), "DDO_CONTLTIPOCON") == 0 )
         {
            /* Execute user subroutine: 'LOADCONTLTIPOCONOPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV42OptionsJson = AV29Options.toJSonString(false) ;
      AV43OptionsDescJson = AV31OptionsDesc.toJSonString(false) ;
      AV44OptionIndexesJson = AV32OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV34Session.getValue("ConceptoTipoLiquidacionWWGridState"), "") == 0 )
      {
         AV36GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ConceptoTipoLiquidacionWWGridState"), null, null);
      }
      else
      {
         AV36GridState.fromxml(AV34Session.getValue("ConceptoTipoLiquidacionWWGridState"), null, null);
      }
      AV55GXV1 = 1 ;
      while ( AV55GXV1 <= AV36GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV37GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV36GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV55GXV1));
         if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICOD") == 0 )
         {
            AV11TFCliCod = (int)(GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFCliCod_To = (int)(GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO") == 0 )
         {
            AV14TFConCodigo = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO_SEL") == 0 )
         {
            AV13TFConCodigo_SelsJson = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFConCodigo_Sels.fromJSonString(AV13TFConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQCOD") == 0 )
         {
            AV17TFTLiqCod = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFTLIQCOD_SEL") == 0 )
         {
            AV16TFTLiqCod_SelsJson = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV18TFTLiqCod_Sels.fromJSonString(AV16TFTLiqCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONTLORDEJEC") == 0 )
         {
            AV19TFConTLOrdejec = GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            AV20TFConTLOrdejec_To = GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONTLCONDICION_SEL") == 0 )
         {
            AV23TFConTLCondicion_SelsJson = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV24TFConTLCondicion_Sels.fromJSonString(AV23TFConTLCondicion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONTLCONHAB") == 0 )
         {
            AV25TFConTLConHab = (byte)(GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV26TFConTLConHab_To = (byte)(GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONTLTIPOCON_SEL") == 0 )
         {
            AV48TFConTLTipoCon_SelsJson = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV49TFConTLTipoCon_Sels.fromJSonString(AV48TFConTLTipoCon_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV52MenuOpcCod = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV55GXV1 = (int)(AV55GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCONCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV14TFConCodigo = AV40SearchTxt ;
      AV15TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV57Conceptotipoliquidacionwwds_1_tfclicod = AV11TFCliCod ;
      AV58Conceptotipoliquidacionwwds_2_tfclicod_to = AV12TFCliCod_To ;
      AV59Conceptotipoliquidacionwwds_3_tfconcodigo = AV14TFConCodigo ;
      AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels = AV15TFConCodigo_Sels ;
      AV61Conceptotipoliquidacionwwds_5_tftliqcod = AV17TFTLiqCod ;
      AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels = AV18TFTLiqCod_Sels ;
      AV63Conceptotipoliquidacionwwds_7_tfcontlordejec = AV19TFConTLOrdejec ;
      AV64Conceptotipoliquidacionwwds_8_tfcontlordejec_to = AV20TFConTLOrdejec_To ;
      AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels = AV24TFConTLCondicion_Sels ;
      AV66Conceptotipoliquidacionwwds_10_tfcontlconhab = AV25TFConTLConHab ;
      AV67Conceptotipoliquidacionwwds_11_tfcontlconhab_to = AV26TFConTLConHab_To ;
      AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels = AV49TFConTLTipoCon_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels ,
                                           A32TLiqCod ,
                                           AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels ,
                                           A1410ConTLCondicion ,
                                           AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels ,
                                           A1788ConTLTipoCon ,
                                           AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels ,
                                           Integer.valueOf(AV57Conceptotipoliquidacionwwds_1_tfclicod) ,
                                           Integer.valueOf(AV58Conceptotipoliquidacionwwds_2_tfclicod_to) ,
                                           Integer.valueOf(AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels.size()) ,
                                           AV59Conceptotipoliquidacionwwds_3_tfconcodigo ,
                                           Integer.valueOf(AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels.size()) ,
                                           AV61Conceptotipoliquidacionwwds_5_tftliqcod ,
                                           Long.valueOf(AV63Conceptotipoliquidacionwwds_7_tfcontlordejec) ,
                                           Long.valueOf(AV64Conceptotipoliquidacionwwds_8_tfcontlordejec_to) ,
                                           Integer.valueOf(AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels.size()) ,
                                           Byte.valueOf(AV66Conceptotipoliquidacionwwds_10_tfcontlconhab) ,
                                           Byte.valueOf(AV67Conceptotipoliquidacionwwds_11_tfcontlconhab_to) ,
                                           Integer.valueOf(AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels.size()) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Long.valueOf(A1406ConTLOrdejec) ,
                                           Byte.valueOf(A1470ConTLConHab) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG,
                                           TypeConstants.BYTE
                                           }
      });
      lV59Conceptotipoliquidacionwwds_3_tfconcodigo = GXutil.padr( GXutil.rtrim( AV59Conceptotipoliquidacionwwds_3_tfconcodigo), 10, "%") ;
      lV61Conceptotipoliquidacionwwds_5_tftliqcod = GXutil.padr( GXutil.rtrim( AV61Conceptotipoliquidacionwwds_5_tftliqcod), 20, "%") ;
      /* Using cursor P01KP2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV57Conceptotipoliquidacionwwds_1_tfclicod), Integer.valueOf(AV58Conceptotipoliquidacionwwds_2_tfclicod_to), lV59Conceptotipoliquidacionwwds_3_tfconcodigo, lV61Conceptotipoliquidacionwwds_5_tftliqcod, Long.valueOf(AV63Conceptotipoliquidacionwwds_7_tfcontlordejec), Long.valueOf(AV64Conceptotipoliquidacionwwds_8_tfcontlordejec_to), Byte.valueOf(AV66Conceptotipoliquidacionwwds_10_tfcontlconhab), Byte.valueOf(AV67Conceptotipoliquidacionwwds_11_tfcontlconhab_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1KP2 = false ;
         A26ConCodigo = P01KP2_A26ConCodigo[0] ;
         A1788ConTLTipoCon = P01KP2_A1788ConTLTipoCon[0] ;
         n1788ConTLTipoCon = P01KP2_n1788ConTLTipoCon[0] ;
         A1470ConTLConHab = P01KP2_A1470ConTLConHab[0] ;
         A1410ConTLCondicion = P01KP2_A1410ConTLCondicion[0] ;
         n1410ConTLCondicion = P01KP2_n1410ConTLCondicion[0] ;
         A1406ConTLOrdejec = P01KP2_A1406ConTLOrdejec[0] ;
         A32TLiqCod = P01KP2_A32TLiqCod[0] ;
         A3CliCod = P01KP2_A3CliCod[0] ;
         AV33count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01KP2_A26ConCodigo[0], A26ConCodigo) == 0 ) )
         {
            brk1KP2 = false ;
            A32TLiqCod = P01KP2_A32TLiqCod[0] ;
            A3CliCod = P01KP2_A3CliCod[0] ;
            AV33count = (long)(AV33count+1) ;
            brk1KP2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A26ConCodigo)==0) )
         {
            AV28Option = A26ConCodigo ;
            AV30OptionDesc = GXutil.trim( GXutil.rtrim( localUtil.format( A26ConCodigo, ""))) ;
            AV29Options.add(AV28Option, 0);
            AV31OptionsDesc.add(AV30OptionDesc, 0);
            AV32OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV33count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV29Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1KP2 )
         {
            brk1KP2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADTLIQCODOPTIONS' Routine */
      returnInSub = false ;
      AV17TFTLiqCod = AV40SearchTxt ;
      AV18TFTLiqCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV57Conceptotipoliquidacionwwds_1_tfclicod = AV11TFCliCod ;
      AV58Conceptotipoliquidacionwwds_2_tfclicod_to = AV12TFCliCod_To ;
      AV59Conceptotipoliquidacionwwds_3_tfconcodigo = AV14TFConCodigo ;
      AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels = AV15TFConCodigo_Sels ;
      AV61Conceptotipoliquidacionwwds_5_tftliqcod = AV17TFTLiqCod ;
      AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels = AV18TFTLiqCod_Sels ;
      AV63Conceptotipoliquidacionwwds_7_tfcontlordejec = AV19TFConTLOrdejec ;
      AV64Conceptotipoliquidacionwwds_8_tfcontlordejec_to = AV20TFConTLOrdejec_To ;
      AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels = AV24TFConTLCondicion_Sels ;
      AV66Conceptotipoliquidacionwwds_10_tfcontlconhab = AV25TFConTLConHab ;
      AV67Conceptotipoliquidacionwwds_11_tfcontlconhab_to = AV26TFConTLConHab_To ;
      AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels = AV49TFConTLTipoCon_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels ,
                                           A32TLiqCod ,
                                           AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels ,
                                           A1410ConTLCondicion ,
                                           AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels ,
                                           A1788ConTLTipoCon ,
                                           AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels ,
                                           Integer.valueOf(AV57Conceptotipoliquidacionwwds_1_tfclicod) ,
                                           Integer.valueOf(AV58Conceptotipoliquidacionwwds_2_tfclicod_to) ,
                                           Integer.valueOf(AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels.size()) ,
                                           AV59Conceptotipoliquidacionwwds_3_tfconcodigo ,
                                           Integer.valueOf(AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels.size()) ,
                                           AV61Conceptotipoliquidacionwwds_5_tftliqcod ,
                                           Long.valueOf(AV63Conceptotipoliquidacionwwds_7_tfcontlordejec) ,
                                           Long.valueOf(AV64Conceptotipoliquidacionwwds_8_tfcontlordejec_to) ,
                                           Integer.valueOf(AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels.size()) ,
                                           Byte.valueOf(AV66Conceptotipoliquidacionwwds_10_tfcontlconhab) ,
                                           Byte.valueOf(AV67Conceptotipoliquidacionwwds_11_tfcontlconhab_to) ,
                                           Integer.valueOf(AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels.size()) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Long.valueOf(A1406ConTLOrdejec) ,
                                           Byte.valueOf(A1470ConTLConHab) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG,
                                           TypeConstants.BYTE
                                           }
      });
      lV59Conceptotipoliquidacionwwds_3_tfconcodigo = GXutil.padr( GXutil.rtrim( AV59Conceptotipoliquidacionwwds_3_tfconcodigo), 10, "%") ;
      lV61Conceptotipoliquidacionwwds_5_tftliqcod = GXutil.padr( GXutil.rtrim( AV61Conceptotipoliquidacionwwds_5_tftliqcod), 20, "%") ;
      /* Using cursor P01KP3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV57Conceptotipoliquidacionwwds_1_tfclicod), Integer.valueOf(AV58Conceptotipoliquidacionwwds_2_tfclicod_to), lV59Conceptotipoliquidacionwwds_3_tfconcodigo, lV61Conceptotipoliquidacionwwds_5_tftliqcod, Long.valueOf(AV63Conceptotipoliquidacionwwds_7_tfcontlordejec), Long.valueOf(AV64Conceptotipoliquidacionwwds_8_tfcontlordejec_to), Byte.valueOf(AV66Conceptotipoliquidacionwwds_10_tfcontlconhab), Byte.valueOf(AV67Conceptotipoliquidacionwwds_11_tfcontlconhab_to)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1KP4 = false ;
         A32TLiqCod = P01KP3_A32TLiqCod[0] ;
         A1788ConTLTipoCon = P01KP3_A1788ConTLTipoCon[0] ;
         n1788ConTLTipoCon = P01KP3_n1788ConTLTipoCon[0] ;
         A1470ConTLConHab = P01KP3_A1470ConTLConHab[0] ;
         A1410ConTLCondicion = P01KP3_A1410ConTLCondicion[0] ;
         n1410ConTLCondicion = P01KP3_n1410ConTLCondicion[0] ;
         A1406ConTLOrdejec = P01KP3_A1406ConTLOrdejec[0] ;
         A26ConCodigo = P01KP3_A26ConCodigo[0] ;
         A3CliCod = P01KP3_A3CliCod[0] ;
         AV33count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01KP3_A32TLiqCod[0], A32TLiqCod) == 0 ) )
         {
            brk1KP4 = false ;
            A26ConCodigo = P01KP3_A26ConCodigo[0] ;
            A3CliCod = P01KP3_A3CliCod[0] ;
            AV33count = (long)(AV33count+1) ;
            brk1KP4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A32TLiqCod)==0) )
         {
            AV28Option = A32TLiqCod ;
            AV29Options.add(AV28Option, 0);
            AV32OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV33count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV29Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1KP4 )
         {
            brk1KP4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADCONTLCONDICIONOPTIONS' Routine */
      returnInSub = false ;
      AV24TFConTLCondicion_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV57Conceptotipoliquidacionwwds_1_tfclicod = AV11TFCliCod ;
      AV58Conceptotipoliquidacionwwds_2_tfclicod_to = AV12TFCliCod_To ;
      AV59Conceptotipoliquidacionwwds_3_tfconcodigo = AV14TFConCodigo ;
      AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels = AV15TFConCodigo_Sels ;
      AV61Conceptotipoliquidacionwwds_5_tftliqcod = AV17TFTLiqCod ;
      AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels = AV18TFTLiqCod_Sels ;
      AV63Conceptotipoliquidacionwwds_7_tfcontlordejec = AV19TFConTLOrdejec ;
      AV64Conceptotipoliquidacionwwds_8_tfcontlordejec_to = AV20TFConTLOrdejec_To ;
      AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels = AV24TFConTLCondicion_Sels ;
      AV66Conceptotipoliquidacionwwds_10_tfcontlconhab = AV25TFConTLConHab ;
      AV67Conceptotipoliquidacionwwds_11_tfcontlconhab_to = AV26TFConTLConHab_To ;
      AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels = AV49TFConTLTipoCon_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels ,
                                           A32TLiqCod ,
                                           AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels ,
                                           A1410ConTLCondicion ,
                                           AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels ,
                                           A1788ConTLTipoCon ,
                                           AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels ,
                                           Integer.valueOf(AV57Conceptotipoliquidacionwwds_1_tfclicod) ,
                                           Integer.valueOf(AV58Conceptotipoliquidacionwwds_2_tfclicod_to) ,
                                           Integer.valueOf(AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels.size()) ,
                                           AV59Conceptotipoliquidacionwwds_3_tfconcodigo ,
                                           Integer.valueOf(AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels.size()) ,
                                           AV61Conceptotipoliquidacionwwds_5_tftliqcod ,
                                           Long.valueOf(AV63Conceptotipoliquidacionwwds_7_tfcontlordejec) ,
                                           Long.valueOf(AV64Conceptotipoliquidacionwwds_8_tfcontlordejec_to) ,
                                           Integer.valueOf(AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels.size()) ,
                                           Byte.valueOf(AV66Conceptotipoliquidacionwwds_10_tfcontlconhab) ,
                                           Byte.valueOf(AV67Conceptotipoliquidacionwwds_11_tfcontlconhab_to) ,
                                           Integer.valueOf(AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels.size()) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Long.valueOf(A1406ConTLOrdejec) ,
                                           Byte.valueOf(A1470ConTLConHab) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG,
                                           TypeConstants.BYTE
                                           }
      });
      lV59Conceptotipoliquidacionwwds_3_tfconcodigo = GXutil.padr( GXutil.rtrim( AV59Conceptotipoliquidacionwwds_3_tfconcodigo), 10, "%") ;
      lV61Conceptotipoliquidacionwwds_5_tftliqcod = GXutil.padr( GXutil.rtrim( AV61Conceptotipoliquidacionwwds_5_tftliqcod), 20, "%") ;
      /* Using cursor P01KP4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV57Conceptotipoliquidacionwwds_1_tfclicod), Integer.valueOf(AV58Conceptotipoliquidacionwwds_2_tfclicod_to), lV59Conceptotipoliquidacionwwds_3_tfconcodigo, lV61Conceptotipoliquidacionwwds_5_tftliqcod, Long.valueOf(AV63Conceptotipoliquidacionwwds_7_tfcontlordejec), Long.valueOf(AV64Conceptotipoliquidacionwwds_8_tfcontlordejec_to), Byte.valueOf(AV66Conceptotipoliquidacionwwds_10_tfcontlconhab), Byte.valueOf(AV67Conceptotipoliquidacionwwds_11_tfcontlconhab_to)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk1KP6 = false ;
         A1410ConTLCondicion = P01KP4_A1410ConTLCondicion[0] ;
         n1410ConTLCondicion = P01KP4_n1410ConTLCondicion[0] ;
         A1788ConTLTipoCon = P01KP4_A1788ConTLTipoCon[0] ;
         n1788ConTLTipoCon = P01KP4_n1788ConTLTipoCon[0] ;
         A1470ConTLConHab = P01KP4_A1470ConTLConHab[0] ;
         A1406ConTLOrdejec = P01KP4_A1406ConTLOrdejec[0] ;
         A32TLiqCod = P01KP4_A32TLiqCod[0] ;
         A26ConCodigo = P01KP4_A26ConCodigo[0] ;
         A3CliCod = P01KP4_A3CliCod[0] ;
         AV33count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P01KP4_A1410ConTLCondicion[0], A1410ConTLCondicion) == 0 ) )
         {
            brk1KP6 = false ;
            A32TLiqCod = P01KP4_A32TLiqCod[0] ;
            A26ConCodigo = P01KP4_A26ConCodigo[0] ;
            A3CliCod = P01KP4_A3CliCod[0] ;
            AV33count = (long)(AV33count+1) ;
            brk1KP6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A1410ConTLCondicion)==0) )
         {
            AV28Option = A1410ConTLCondicion ;
            AV29Options.add(AV28Option, 0);
            AV32OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV33count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV29Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1KP6 )
         {
            brk1KP6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADCONTLTIPOCONOPTIONS' Routine */
      returnInSub = false ;
      AV49TFConTLTipoCon_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV57Conceptotipoliquidacionwwds_1_tfclicod = AV11TFCliCod ;
      AV58Conceptotipoliquidacionwwds_2_tfclicod_to = AV12TFCliCod_To ;
      AV59Conceptotipoliquidacionwwds_3_tfconcodigo = AV14TFConCodigo ;
      AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels = AV15TFConCodigo_Sels ;
      AV61Conceptotipoliquidacionwwds_5_tftliqcod = AV17TFTLiqCod ;
      AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels = AV18TFTLiqCod_Sels ;
      AV63Conceptotipoliquidacionwwds_7_tfcontlordejec = AV19TFConTLOrdejec ;
      AV64Conceptotipoliquidacionwwds_8_tfcontlordejec_to = AV20TFConTLOrdejec_To ;
      AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels = AV24TFConTLCondicion_Sels ;
      AV66Conceptotipoliquidacionwwds_10_tfcontlconhab = AV25TFConTLConHab ;
      AV67Conceptotipoliquidacionwwds_11_tfcontlconhab_to = AV26TFConTLConHab_To ;
      AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels = AV49TFConTLTipoCon_Sels ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels ,
                                           A32TLiqCod ,
                                           AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels ,
                                           A1410ConTLCondicion ,
                                           AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels ,
                                           A1788ConTLTipoCon ,
                                           AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels ,
                                           Integer.valueOf(AV57Conceptotipoliquidacionwwds_1_tfclicod) ,
                                           Integer.valueOf(AV58Conceptotipoliquidacionwwds_2_tfclicod_to) ,
                                           Integer.valueOf(AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels.size()) ,
                                           AV59Conceptotipoliquidacionwwds_3_tfconcodigo ,
                                           Integer.valueOf(AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels.size()) ,
                                           AV61Conceptotipoliquidacionwwds_5_tftliqcod ,
                                           Long.valueOf(AV63Conceptotipoliquidacionwwds_7_tfcontlordejec) ,
                                           Long.valueOf(AV64Conceptotipoliquidacionwwds_8_tfcontlordejec_to) ,
                                           Integer.valueOf(AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels.size()) ,
                                           Byte.valueOf(AV66Conceptotipoliquidacionwwds_10_tfcontlconhab) ,
                                           Byte.valueOf(AV67Conceptotipoliquidacionwwds_11_tfcontlconhab_to) ,
                                           Integer.valueOf(AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels.size()) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Long.valueOf(A1406ConTLOrdejec) ,
                                           Byte.valueOf(A1470ConTLConHab) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.LONG,
                                           TypeConstants.BYTE
                                           }
      });
      lV59Conceptotipoliquidacionwwds_3_tfconcodigo = GXutil.padr( GXutil.rtrim( AV59Conceptotipoliquidacionwwds_3_tfconcodigo), 10, "%") ;
      lV61Conceptotipoliquidacionwwds_5_tftliqcod = GXutil.padr( GXutil.rtrim( AV61Conceptotipoliquidacionwwds_5_tftliqcod), 20, "%") ;
      /* Using cursor P01KP5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV57Conceptotipoliquidacionwwds_1_tfclicod), Integer.valueOf(AV58Conceptotipoliquidacionwwds_2_tfclicod_to), lV59Conceptotipoliquidacionwwds_3_tfconcodigo, lV61Conceptotipoliquidacionwwds_5_tftliqcod, Long.valueOf(AV63Conceptotipoliquidacionwwds_7_tfcontlordejec), Long.valueOf(AV64Conceptotipoliquidacionwwds_8_tfcontlordejec_to), Byte.valueOf(AV66Conceptotipoliquidacionwwds_10_tfcontlconhab), Byte.valueOf(AV67Conceptotipoliquidacionwwds_11_tfcontlconhab_to)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk1KP8 = false ;
         A1788ConTLTipoCon = P01KP5_A1788ConTLTipoCon[0] ;
         n1788ConTLTipoCon = P01KP5_n1788ConTLTipoCon[0] ;
         A1470ConTLConHab = P01KP5_A1470ConTLConHab[0] ;
         A1410ConTLCondicion = P01KP5_A1410ConTLCondicion[0] ;
         n1410ConTLCondicion = P01KP5_n1410ConTLCondicion[0] ;
         A1406ConTLOrdejec = P01KP5_A1406ConTLOrdejec[0] ;
         A32TLiqCod = P01KP5_A32TLiqCod[0] ;
         A26ConCodigo = P01KP5_A26ConCodigo[0] ;
         A3CliCod = P01KP5_A3CliCod[0] ;
         AV33count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P01KP5_A1788ConTLTipoCon[0], A1788ConTLTipoCon) == 0 ) )
         {
            brk1KP8 = false ;
            A32TLiqCod = P01KP5_A32TLiqCod[0] ;
            A26ConCodigo = P01KP5_A26ConCodigo[0] ;
            A3CliCod = P01KP5_A3CliCod[0] ;
            AV33count = (long)(AV33count+1) ;
            brk1KP8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A1788ConTLTipoCon)==0) )
         {
            AV28Option = A1788ConTLTipoCon ;
            AV29Options.add(AV28Option, 0);
            AV32OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV33count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV29Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1KP8 )
         {
            brk1KP8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   protected void cleanup( )
   {
      this.aP3[0] = conceptotipoliquidacionwwgetfilterdata.this.AV42OptionsJson;
      this.aP4[0] = conceptotipoliquidacionwwgetfilterdata.this.AV43OptionsDescJson;
      this.aP5[0] = conceptotipoliquidacionwwgetfilterdata.this.AV44OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV42OptionsJson = "" ;
      AV43OptionsDescJson = "" ;
      AV44OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV29Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV31OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV32OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV34Session = httpContext.getWebSession();
      AV36GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV37GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV14TFConCodigo = "" ;
      AV13TFConCodigo_SelsJson = "" ;
      AV15TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV17TFTLiqCod = "" ;
      AV16TFTLiqCod_SelsJson = "" ;
      AV18TFTLiqCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23TFConTLCondicion_SelsJson = "" ;
      AV24TFConTLCondicion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV48TFConTLTipoCon_SelsJson = "" ;
      AV49TFConTLTipoCon_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52MenuOpcCod = "" ;
      A26ConCodigo = "" ;
      AV59Conceptotipoliquidacionwwds_3_tfconcodigo = "" ;
      AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV61Conceptotipoliquidacionwwds_5_tftliqcod = "" ;
      AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV59Conceptotipoliquidacionwwds_3_tfconcodigo = "" ;
      lV61Conceptotipoliquidacionwwds_5_tftliqcod = "" ;
      A32TLiqCod = "" ;
      A1410ConTLCondicion = "" ;
      A1788ConTLTipoCon = "" ;
      P01KP2_A26ConCodigo = new String[] {""} ;
      P01KP2_A1788ConTLTipoCon = new String[] {""} ;
      P01KP2_n1788ConTLTipoCon = new boolean[] {false} ;
      P01KP2_A1470ConTLConHab = new byte[1] ;
      P01KP2_A1410ConTLCondicion = new String[] {""} ;
      P01KP2_n1410ConTLCondicion = new boolean[] {false} ;
      P01KP2_A1406ConTLOrdejec = new long[1] ;
      P01KP2_A32TLiqCod = new String[] {""} ;
      P01KP2_A3CliCod = new int[1] ;
      AV28Option = "" ;
      AV30OptionDesc = "" ;
      P01KP3_A32TLiqCod = new String[] {""} ;
      P01KP3_A1788ConTLTipoCon = new String[] {""} ;
      P01KP3_n1788ConTLTipoCon = new boolean[] {false} ;
      P01KP3_A1470ConTLConHab = new byte[1] ;
      P01KP3_A1410ConTLCondicion = new String[] {""} ;
      P01KP3_n1410ConTLCondicion = new boolean[] {false} ;
      P01KP3_A1406ConTLOrdejec = new long[1] ;
      P01KP3_A26ConCodigo = new String[] {""} ;
      P01KP3_A3CliCod = new int[1] ;
      P01KP4_A1410ConTLCondicion = new String[] {""} ;
      P01KP4_n1410ConTLCondicion = new boolean[] {false} ;
      P01KP4_A1788ConTLTipoCon = new String[] {""} ;
      P01KP4_n1788ConTLTipoCon = new boolean[] {false} ;
      P01KP4_A1470ConTLConHab = new byte[1] ;
      P01KP4_A1406ConTLOrdejec = new long[1] ;
      P01KP4_A32TLiqCod = new String[] {""} ;
      P01KP4_A26ConCodigo = new String[] {""} ;
      P01KP4_A3CliCod = new int[1] ;
      P01KP5_A1788ConTLTipoCon = new String[] {""} ;
      P01KP5_n1788ConTLTipoCon = new boolean[] {false} ;
      P01KP5_A1470ConTLConHab = new byte[1] ;
      P01KP5_A1410ConTLCondicion = new String[] {""} ;
      P01KP5_n1410ConTLCondicion = new boolean[] {false} ;
      P01KP5_A1406ConTLOrdejec = new long[1] ;
      P01KP5_A32TLiqCod = new String[] {""} ;
      P01KP5_A26ConCodigo = new String[] {""} ;
      P01KP5_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptotipoliquidacionwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01KP2_A26ConCodigo, P01KP2_A1788ConTLTipoCon, P01KP2_n1788ConTLTipoCon, P01KP2_A1470ConTLConHab, P01KP2_A1410ConTLCondicion, P01KP2_n1410ConTLCondicion, P01KP2_A1406ConTLOrdejec, P01KP2_A32TLiqCod, P01KP2_A3CliCod
            }
            , new Object[] {
            P01KP3_A32TLiqCod, P01KP3_A1788ConTLTipoCon, P01KP3_n1788ConTLTipoCon, P01KP3_A1470ConTLConHab, P01KP3_A1410ConTLCondicion, P01KP3_n1410ConTLCondicion, P01KP3_A1406ConTLOrdejec, P01KP3_A26ConCodigo, P01KP3_A3CliCod
            }
            , new Object[] {
            P01KP4_A1410ConTLCondicion, P01KP4_n1410ConTLCondicion, P01KP4_A1788ConTLTipoCon, P01KP4_n1788ConTLTipoCon, P01KP4_A1470ConTLConHab, P01KP4_A1406ConTLOrdejec, P01KP4_A32TLiqCod, P01KP4_A26ConCodigo, P01KP4_A3CliCod
            }
            , new Object[] {
            P01KP5_A1788ConTLTipoCon, P01KP5_n1788ConTLTipoCon, P01KP5_A1470ConTLConHab, P01KP5_A1410ConTLCondicion, P01KP5_n1410ConTLCondicion, P01KP5_A1406ConTLOrdejec, P01KP5_A32TLiqCod, P01KP5_A26ConCodigo, P01KP5_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV25TFConTLConHab ;
   private byte AV26TFConTLConHab_To ;
   private byte AV66Conceptotipoliquidacionwwds_10_tfcontlconhab ;
   private byte AV67Conceptotipoliquidacionwwds_11_tfcontlconhab_to ;
   private byte A1470ConTLConHab ;
   private short AV46EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV47CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV55GXV1 ;
   private int AV11TFCliCod ;
   private int AV12TFCliCod_To ;
   private int AV57Conceptotipoliquidacionwwds_1_tfclicod ;
   private int AV58Conceptotipoliquidacionwwds_2_tfclicod_to ;
   private int AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size ;
   private int AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels_size ;
   private int AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels_size ;
   private int AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels_size ;
   private int A3CliCod ;
   private long AV19TFConTLOrdejec ;
   private long AV20TFConTLOrdejec_To ;
   private long AV63Conceptotipoliquidacionwwds_7_tfcontlordejec ;
   private long AV64Conceptotipoliquidacionwwds_8_tfcontlordejec_to ;
   private long A1406ConTLOrdejec ;
   private long AV33count ;
   private String AV14TFConCodigo ;
   private String AV17TFTLiqCod ;
   private String A26ConCodigo ;
   private String AV59Conceptotipoliquidacionwwds_3_tfconcodigo ;
   private String AV61Conceptotipoliquidacionwwds_5_tftliqcod ;
   private String scmdbuf ;
   private String lV59Conceptotipoliquidacionwwds_3_tfconcodigo ;
   private String lV61Conceptotipoliquidacionwwds_5_tftliqcod ;
   private String A32TLiqCod ;
   private String A1410ConTLCondicion ;
   private String A1788ConTLTipoCon ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1KP2 ;
   private boolean n1788ConTLTipoCon ;
   private boolean n1410ConTLCondicion ;
   private boolean brk1KP4 ;
   private boolean brk1KP6 ;
   private boolean brk1KP8 ;
   private String AV42OptionsJson ;
   private String AV43OptionsDescJson ;
   private String AV44OptionIndexesJson ;
   private String AV13TFConCodigo_SelsJson ;
   private String AV16TFTLiqCod_SelsJson ;
   private String AV23TFConTLCondicion_SelsJson ;
   private String AV48TFConTLTipoCon_SelsJson ;
   private String AV39DDOName ;
   private String AV40SearchTxt ;
   private String AV41SearchTxtTo ;
   private String AV52MenuOpcCod ;
   private String AV28Option ;
   private String AV30OptionDesc ;
   private com.genexus.webpanels.WebSession AV34Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01KP2_A26ConCodigo ;
   private String[] P01KP2_A1788ConTLTipoCon ;
   private boolean[] P01KP2_n1788ConTLTipoCon ;
   private byte[] P01KP2_A1470ConTLConHab ;
   private String[] P01KP2_A1410ConTLCondicion ;
   private boolean[] P01KP2_n1410ConTLCondicion ;
   private long[] P01KP2_A1406ConTLOrdejec ;
   private String[] P01KP2_A32TLiqCod ;
   private int[] P01KP2_A3CliCod ;
   private String[] P01KP3_A32TLiqCod ;
   private String[] P01KP3_A1788ConTLTipoCon ;
   private boolean[] P01KP3_n1788ConTLTipoCon ;
   private byte[] P01KP3_A1470ConTLConHab ;
   private String[] P01KP3_A1410ConTLCondicion ;
   private boolean[] P01KP3_n1410ConTLCondicion ;
   private long[] P01KP3_A1406ConTLOrdejec ;
   private String[] P01KP3_A26ConCodigo ;
   private int[] P01KP3_A3CliCod ;
   private String[] P01KP4_A1410ConTLCondicion ;
   private boolean[] P01KP4_n1410ConTLCondicion ;
   private String[] P01KP4_A1788ConTLTipoCon ;
   private boolean[] P01KP4_n1788ConTLTipoCon ;
   private byte[] P01KP4_A1470ConTLConHab ;
   private long[] P01KP4_A1406ConTLOrdejec ;
   private String[] P01KP4_A32TLiqCod ;
   private String[] P01KP4_A26ConCodigo ;
   private int[] P01KP4_A3CliCod ;
   private String[] P01KP5_A1788ConTLTipoCon ;
   private boolean[] P01KP5_n1788ConTLTipoCon ;
   private byte[] P01KP5_A1470ConTLConHab ;
   private String[] P01KP5_A1410ConTLCondicion ;
   private boolean[] P01KP5_n1410ConTLCondicion ;
   private long[] P01KP5_A1406ConTLOrdejec ;
   private String[] P01KP5_A32TLiqCod ;
   private String[] P01KP5_A26ConCodigo ;
   private int[] P01KP5_A3CliCod ;
   private GXSimpleCollection<String> AV15TFConCodigo_Sels ;
   private GXSimpleCollection<String> AV18TFTLiqCod_Sels ;
   private GXSimpleCollection<String> AV24TFConTLCondicion_Sels ;
   private GXSimpleCollection<String> AV49TFConTLTipoCon_Sels ;
   private GXSimpleCollection<String> AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels ;
   private GXSimpleCollection<String> AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels ;
   private GXSimpleCollection<String> AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels ;
   private GXSimpleCollection<String> AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels ;
   private GXSimpleCollection<String> AV29Options ;
   private GXSimpleCollection<String> AV31OptionsDesc ;
   private GXSimpleCollection<String> AV32OptionIndexes ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV36GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV37GridStateFilterValue ;
}

final  class conceptotipoliquidacionwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01KP2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels ,
                                          String A32TLiqCod ,
                                          GXSimpleCollection<String> AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels ,
                                          String A1410ConTLCondicion ,
                                          GXSimpleCollection<String> AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels ,
                                          String A1788ConTLTipoCon ,
                                          GXSimpleCollection<String> AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels ,
                                          int AV57Conceptotipoliquidacionwwds_1_tfclicod ,
                                          int AV58Conceptotipoliquidacionwwds_2_tfclicod_to ,
                                          int AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size ,
                                          String AV59Conceptotipoliquidacionwwds_3_tfconcodigo ,
                                          int AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels_size ,
                                          String AV61Conceptotipoliquidacionwwds_5_tftliqcod ,
                                          long AV63Conceptotipoliquidacionwwds_7_tfcontlordejec ,
                                          long AV64Conceptotipoliquidacionwwds_8_tfcontlordejec_to ,
                                          int AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels_size ,
                                          byte AV66Conceptotipoliquidacionwwds_10_tfcontlconhab ,
                                          byte AV67Conceptotipoliquidacionwwds_11_tfcontlconhab_to ,
                                          int AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels_size ,
                                          int A3CliCod ,
                                          long A1406ConTLOrdejec ,
                                          byte A1470ConTLConHab )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[8];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT ConCodigo, ConTLTipoCon, ConTLConHab, ConTLCondicion, ConTLOrdejec, TLiqCod, CliCod FROM ConceptoTipoLiquidacion" ;
      if ( ! (0==AV57Conceptotipoliquidacionwwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( ! (0==AV58Conceptotipoliquidacionwwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ( AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV59Conceptotipoliquidacionwwds_3_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels, "ConCodigo IN (", ")")+")");
      }
      if ( ( AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61Conceptotipoliquidacionwwds_5_tftliqcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TLiqCod) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels, "TLiqCod IN (", ")")+")");
      }
      if ( ! (0==AV63Conceptotipoliquidacionwwds_7_tfcontlordejec) )
      {
         addWhere(sWhereString, "(ConTLOrdejec >= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! (0==AV64Conceptotipoliquidacionwwds_8_tfcontlordejec_to) )
      {
         addWhere(sWhereString, "(ConTLOrdejec <= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels, "ConTLCondicion IN (", ")")+")");
      }
      if ( ! (0==AV66Conceptotipoliquidacionwwds_10_tfcontlconhab) )
      {
         addWhere(sWhereString, "(ConTLConHab >= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ! (0==AV67Conceptotipoliquidacionwwds_11_tfcontlconhab_to) )
      {
         addWhere(sWhereString, "(ConTLConHab <= ?)");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels, "ConTLTipoCon IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ConCodigo" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01KP3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels ,
                                          String A32TLiqCod ,
                                          GXSimpleCollection<String> AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels ,
                                          String A1410ConTLCondicion ,
                                          GXSimpleCollection<String> AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels ,
                                          String A1788ConTLTipoCon ,
                                          GXSimpleCollection<String> AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels ,
                                          int AV57Conceptotipoliquidacionwwds_1_tfclicod ,
                                          int AV58Conceptotipoliquidacionwwds_2_tfclicod_to ,
                                          int AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size ,
                                          String AV59Conceptotipoliquidacionwwds_3_tfconcodigo ,
                                          int AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels_size ,
                                          String AV61Conceptotipoliquidacionwwds_5_tftliqcod ,
                                          long AV63Conceptotipoliquidacionwwds_7_tfcontlordejec ,
                                          long AV64Conceptotipoliquidacionwwds_8_tfcontlordejec_to ,
                                          int AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels_size ,
                                          byte AV66Conceptotipoliquidacionwwds_10_tfcontlconhab ,
                                          byte AV67Conceptotipoliquidacionwwds_11_tfcontlconhab_to ,
                                          int AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels_size ,
                                          int A3CliCod ,
                                          long A1406ConTLOrdejec ,
                                          byte A1470ConTLConHab )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[8];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT TLiqCod, ConTLTipoCon, ConTLConHab, ConTLCondicion, ConTLOrdejec, ConCodigo, CliCod FROM ConceptoTipoLiquidacion" ;
      if ( ! (0==AV57Conceptotipoliquidacionwwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( ! (0==AV58Conceptotipoliquidacionwwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( ( AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV59Conceptotipoliquidacionwwds_3_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels, "ConCodigo IN (", ")")+")");
      }
      if ( ( AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61Conceptotipoliquidacionwwds_5_tftliqcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TLiqCod) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels, "TLiqCod IN (", ")")+")");
      }
      if ( ! (0==AV63Conceptotipoliquidacionwwds_7_tfcontlordejec) )
      {
         addWhere(sWhereString, "(ConTLOrdejec >= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! (0==AV64Conceptotipoliquidacionwwds_8_tfcontlordejec_to) )
      {
         addWhere(sWhereString, "(ConTLOrdejec <= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels, "ConTLCondicion IN (", ")")+")");
      }
      if ( ! (0==AV66Conceptotipoliquidacionwwds_10_tfcontlconhab) )
      {
         addWhere(sWhereString, "(ConTLConHab >= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ! (0==AV67Conceptotipoliquidacionwwds_11_tfcontlconhab_to) )
      {
         addWhere(sWhereString, "(ConTLConHab <= ?)");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels, "ConTLTipoCon IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY TLiqCod" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P01KP4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels ,
                                          String A32TLiqCod ,
                                          GXSimpleCollection<String> AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels ,
                                          String A1410ConTLCondicion ,
                                          GXSimpleCollection<String> AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels ,
                                          String A1788ConTLTipoCon ,
                                          GXSimpleCollection<String> AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels ,
                                          int AV57Conceptotipoliquidacionwwds_1_tfclicod ,
                                          int AV58Conceptotipoliquidacionwwds_2_tfclicod_to ,
                                          int AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size ,
                                          String AV59Conceptotipoliquidacionwwds_3_tfconcodigo ,
                                          int AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels_size ,
                                          String AV61Conceptotipoliquidacionwwds_5_tftliqcod ,
                                          long AV63Conceptotipoliquidacionwwds_7_tfcontlordejec ,
                                          long AV64Conceptotipoliquidacionwwds_8_tfcontlordejec_to ,
                                          int AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels_size ,
                                          byte AV66Conceptotipoliquidacionwwds_10_tfcontlconhab ,
                                          byte AV67Conceptotipoliquidacionwwds_11_tfcontlconhab_to ,
                                          int AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels_size ,
                                          int A3CliCod ,
                                          long A1406ConTLOrdejec ,
                                          byte A1470ConTLConHab )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[8];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT ConTLCondicion, ConTLTipoCon, ConTLConHab, ConTLOrdejec, TLiqCod, ConCodigo, CliCod FROM ConceptoTipoLiquidacion" ;
      if ( ! (0==AV57Conceptotipoliquidacionwwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int14[0] = (byte)(1) ;
      }
      if ( ! (0==AV58Conceptotipoliquidacionwwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( ( AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV59Conceptotipoliquidacionwwds_3_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels, "ConCodigo IN (", ")")+")");
      }
      if ( ( AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61Conceptotipoliquidacionwwds_5_tftliqcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TLiqCod) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels, "TLiqCod IN (", ")")+")");
      }
      if ( ! (0==AV63Conceptotipoliquidacionwwds_7_tfcontlordejec) )
      {
         addWhere(sWhereString, "(ConTLOrdejec >= ?)");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( ! (0==AV64Conceptotipoliquidacionwwds_8_tfcontlordejec_to) )
      {
         addWhere(sWhereString, "(ConTLOrdejec <= ?)");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels, "ConTLCondicion IN (", ")")+")");
      }
      if ( ! (0==AV66Conceptotipoliquidacionwwds_10_tfcontlconhab) )
      {
         addWhere(sWhereString, "(ConTLConHab >= ?)");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      if ( ! (0==AV67Conceptotipoliquidacionwwds_11_tfcontlconhab_to) )
      {
         addWhere(sWhereString, "(ConTLConHab <= ?)");
      }
      else
      {
         GXv_int14[7] = (byte)(1) ;
      }
      if ( AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels, "ConTLTipoCon IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ConTLCondicion" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   protected Object[] conditional_P01KP5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels ,
                                          String A32TLiqCod ,
                                          GXSimpleCollection<String> AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels ,
                                          String A1410ConTLCondicion ,
                                          GXSimpleCollection<String> AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels ,
                                          String A1788ConTLTipoCon ,
                                          GXSimpleCollection<String> AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels ,
                                          int AV57Conceptotipoliquidacionwwds_1_tfclicod ,
                                          int AV58Conceptotipoliquidacionwwds_2_tfclicod_to ,
                                          int AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size ,
                                          String AV59Conceptotipoliquidacionwwds_3_tfconcodigo ,
                                          int AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels_size ,
                                          String AV61Conceptotipoliquidacionwwds_5_tftliqcod ,
                                          long AV63Conceptotipoliquidacionwwds_7_tfcontlordejec ,
                                          long AV64Conceptotipoliquidacionwwds_8_tfcontlordejec_to ,
                                          int AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels_size ,
                                          byte AV66Conceptotipoliquidacionwwds_10_tfcontlconhab ,
                                          byte AV67Conceptotipoliquidacionwwds_11_tfcontlconhab_to ,
                                          int AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels_size ,
                                          int A3CliCod ,
                                          long A1406ConTLOrdejec ,
                                          byte A1470ConTLConHab )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[8];
      Object[] GXv_Object18 = new Object[2];
      scmdbuf = "SELECT ConTLTipoCon, ConTLConHab, ConTLCondicion, ConTLOrdejec, TLiqCod, ConCodigo, CliCod FROM ConceptoTipoLiquidacion" ;
      if ( ! (0==AV57Conceptotipoliquidacionwwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int17[0] = (byte)(1) ;
      }
      if ( ! (0==AV58Conceptotipoliquidacionwwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int17[1] = (byte)(1) ;
      }
      if ( ( AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV59Conceptotipoliquidacionwwds_3_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int17[2] = (byte)(1) ;
      }
      if ( AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV60Conceptotipoliquidacionwwds_4_tfconcodigo_sels, "ConCodigo IN (", ")")+")");
      }
      if ( ( AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV61Conceptotipoliquidacionwwds_5_tftliqcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(TLiqCod) like LOWER(?))");
      }
      else
      {
         GXv_int17[3] = (byte)(1) ;
      }
      if ( AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV62Conceptotipoliquidacionwwds_6_tftliqcod_sels, "TLiqCod IN (", ")")+")");
      }
      if ( ! (0==AV63Conceptotipoliquidacionwwds_7_tfcontlordejec) )
      {
         addWhere(sWhereString, "(ConTLOrdejec >= ?)");
      }
      else
      {
         GXv_int17[4] = (byte)(1) ;
      }
      if ( ! (0==AV64Conceptotipoliquidacionwwds_8_tfcontlordejec_to) )
      {
         addWhere(sWhereString, "(ConTLOrdejec <= ?)");
      }
      else
      {
         GXv_int17[5] = (byte)(1) ;
      }
      if ( AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV65Conceptotipoliquidacionwwds_9_tfcontlcondicion_sels, "ConTLCondicion IN (", ")")+")");
      }
      if ( ! (0==AV66Conceptotipoliquidacionwwds_10_tfcontlconhab) )
      {
         addWhere(sWhereString, "(ConTLConHab >= ?)");
      }
      else
      {
         GXv_int17[6] = (byte)(1) ;
      }
      if ( ! (0==AV67Conceptotipoliquidacionwwds_11_tfcontlconhab_to) )
      {
         addWhere(sWhereString, "(ConTLConHab <= ?)");
      }
      else
      {
         GXv_int17[7] = (byte)(1) ;
      }
      if ( AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Conceptotipoliquidacionwwds_12_tfcontltipocon_sels, "ConTLTipoCon IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ConTLTipoCon" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
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
                  return conditional_P01KP2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).longValue() , ((Number) dynConstraints[15]).longValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).byteValue() , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).longValue() , ((Number) dynConstraints[22]).byteValue() );
            case 1 :
                  return conditional_P01KP3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).longValue() , ((Number) dynConstraints[15]).longValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).byteValue() , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).longValue() , ((Number) dynConstraints[22]).byteValue() );
            case 2 :
                  return conditional_P01KP4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).longValue() , ((Number) dynConstraints[15]).longValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).byteValue() , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).longValue() , ((Number) dynConstraints[22]).byteValue() );
            case 3 :
                  return conditional_P01KP5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).longValue() , ((Number) dynConstraints[15]).longValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).byteValue() , ((Number) dynConstraints[18]).byteValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).longValue() , ((Number) dynConstraints[22]).byteValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01KP2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01KP3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01KP4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01KP5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((byte[]) buf[3])[0] = rslt.getByte(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((long[]) buf[6])[0] = rslt.getLong(5);
               ((String[]) buf[7])[0] = rslt.getString(6, 20);
               ((int[]) buf[8])[0] = rslt.getInt(7);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((byte[]) buf[3])[0] = rslt.getByte(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((long[]) buf[6])[0] = rslt.getLong(5);
               ((String[]) buf[7])[0] = rslt.getString(6, 10);
               ((int[]) buf[8])[0] = rslt.getInt(7);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((byte[]) buf[4])[0] = rslt.getByte(3);
               ((long[]) buf[5])[0] = rslt.getLong(4);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((String[]) buf[7])[0] = rslt.getString(6, 10);
               ((int[]) buf[8])[0] = rslt.getInt(7);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((byte[]) buf[2])[0] = rslt.getByte(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((long[]) buf[5])[0] = rslt.getLong(4);
               ((String[]) buf[6])[0] = rslt.getString(5, 20);
               ((String[]) buf[7])[0] = rslt.getString(6, 10);
               ((int[]) buf[8])[0] = rslt.getInt(7);
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
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 10);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[12]).longValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[13]).longValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[14]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[15]).byteValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 10);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[12]).longValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[13]).longValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[14]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[15]).byteValue());
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 10);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[12]).longValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[13]).longValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[14]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[15]).byteValue());
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 10);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[12]).longValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[13]).longValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[14]).byteValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[15]).byteValue());
               }
               return;
      }
   }

}

