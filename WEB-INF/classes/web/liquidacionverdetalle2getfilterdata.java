package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liquidacionverdetalle2getfilterdata extends GXProcedure
{
   public liquidacionverdetalle2getfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacionverdetalle2getfilterdata.class ), "" );
   }

   public liquidacionverdetalle2getfilterdata( int remoteHandle ,
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
      liquidacionverdetalle2getfilterdata.this.aP5 = new String[] {""};
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
      liquidacionverdetalle2getfilterdata.this.AV31DDOName = aP0;
      liquidacionverdetalle2getfilterdata.this.AV29SearchTxt = aP1;
      liquidacionverdetalle2getfilterdata.this.AV30SearchTxtTo = aP2;
      liquidacionverdetalle2getfilterdata.this.aP3 = aP3;
      liquidacionverdetalle2getfilterdata.this.aP4 = aP4;
      liquidacionverdetalle2getfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV50CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      liquidacionverdetalle2getfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV50CliCod = GXt_int1 ;
      AV34Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV37OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV39OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean3 = AV8IsAuthorized ;
      GXv_boolean4[0] = GXt_boolean3 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "LiquidacionVerDetalle", GXv_boolean4) ;
      liquidacionverdetalle2getfilterdata.this.GXt_boolean3 = GXv_boolean4[0] ;
      AV8IsAuthorized = GXt_boolean3 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext5[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
         AV9WWPContext = GXv_SdtWWPContext5[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV31DDOName), "DDO_LIQDCLASIFAUX") == 0 )
         {
            /* Execute user subroutine: 'LOADLIQDCLASIFAUXOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV31DDOName), "DDO_DCONCODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADDCONCODIGOOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV31DDOName), "DDO_DCONDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADDCONDESCRIPOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV31DDOName), "DDO_LIQDERRORDESC") == 0 )
         {
            /* Execute user subroutine: 'LOADLIQDERRORDESCOPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV35OptionsJson = AV34Options.toJSonString(false) ;
      AV38OptionsDescJson = AV37OptionsDesc.toJSonString(false) ;
      AV40OptionIndexesJson = AV39OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV42Session.getValue("LiquidacionVerDetalle2GridState"), "") == 0 )
      {
         AV44GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LiquidacionVerDetalle2GridState"), null, null);
      }
      else
      {
         AV44GridState.fromxml(AV42Session.getValue("LiquidacionVerDetalle2GridState"), null, null);
      }
      AV96GXV1 = 1 ;
      while ( AV96GXV1 <= AV44GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV45GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV44GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV96GXV1));
         if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "MOSTRAR") == 0 )
         {
            AV88Mostrar = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDTIPOCONCOD_SEL") == 0 )
         {
            AV11TFDTipoConCod_SelsJson = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV12TFDTipoConCod_Sels.fromJSonString(AV11TFDTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDCLASIFAUX") == 0 )
         {
            AV91TFLiqDClasifAux = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDCLASIFAUX_SEL") == 0 )
         {
            AV90TFLiqDClasifAux_SelsJson = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV92TFLiqDClasifAux_Sels.fromJSonString(AV90TFLiqDClasifAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONCODIGO") == 0 )
         {
            AV14TFDConCodigo = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONCODIGO_SEL") == 0 )
         {
            AV13TFDConCodigo_SelsJson = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFDConCodigo_Sels.fromJSonString(AV13TFDConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONDESCRIP") == 0 )
         {
            AV17TFDConDescrip = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONDESCRIP_SEL") == 0 )
         {
            AV16TFDConDescrip_SelsJson = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV18TFDConDescrip_Sels.fromJSonString(AV16TFDConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDVALUNI") == 0 )
         {
            AV19TFLiqDValUni = CommonUtil.decimalVal( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV20TFLiqDValUni_To = CommonUtil.decimalVal( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDIMPRECALCU") == 0 )
         {
            AV58TFLiqDImpReCalcu = CommonUtil.decimalVal( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV59TFLiqDImpReCalcu_To = CommonUtil.decimalVal( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDERRORDESC") == 0 )
         {
            AV27TFLiqDErrorDesc = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDERRORDESC_SEL") == 0 )
         {
            AV26TFLiqDErrorDesc_SelsJson = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV28TFLiqDErrorDesc_Sels.fromJSonString(AV26TFLiqDErrorDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&AUXMENUOPCCOD") == 0 )
         {
            AV93auxMenuOpcCod = AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV50CliCod = (int)(GXutil.lval( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV47EmpCod = (short)(GXutil.lval( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LIQNRO") == 0 )
         {
            AV48LiqNro = (int)(GXutil.lval( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LEGNUMERO") == 0 )
         {
            AV49LegNumero = (int)(GXutil.lval( AV45GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV96GXV1 = (int)(AV96GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLIQDCLASIFAUXOPTIONS' Routine */
      returnInSub = false ;
      AV91TFLiqDClasifAux = AV29SearchTxt ;
      AV92TFLiqDClasifAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV98Liquidacionverdetalle2ds_1_mostrar = AV88Mostrar ;
      AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels = AV12TFDTipoConCod_Sels ;
      AV100Liquidacionverdetalle2ds_3_tfliqdclasifaux = AV91TFLiqDClasifAux ;
      AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels = AV92TFLiqDClasifAux_Sels ;
      AV102Liquidacionverdetalle2ds_5_tfdconcodigo = AV14TFDConCodigo ;
      AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels = AV15TFDConCodigo_Sels ;
      AV104Liquidacionverdetalle2ds_7_tfdcondescrip = AV17TFDConDescrip ;
      AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels = AV18TFDConDescrip_Sels ;
      AV106Liquidacionverdetalle2ds_9_tfliqdvaluni = AV19TFLiqDValUni ;
      AV107Liquidacionverdetalle2ds_10_tfliqdvaluni_to = AV20TFLiqDValUni_To ;
      AV108Liquidacionverdetalle2ds_11_tfliqdimprecalcu = AV58TFLiqDImpReCalcu ;
      AV109Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to = AV59TFLiqDImpReCalcu_To ;
      AV110Liquidacionverdetalle2ds_13_tfliqderrordesc = AV27TFLiqDErrorDesc ;
      AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels = AV28TFLiqDErrorDesc_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A464DTipoConCod ,
                                           AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels ,
                                           A2149LiqDClasifAux ,
                                           AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels ,
                                           A394DConCodigo ,
                                           AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels ,
                                           A393DConDescrip ,
                                           AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels ,
                                           A270LiqDErrorDesc ,
                                           AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels ,
                                           AV98Liquidacionverdetalle2ds_1_mostrar ,
                                           Integer.valueOf(AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels.size()) ,
                                           Integer.valueOf(AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels.size()) ,
                                           AV100Liquidacionverdetalle2ds_3_tfliqdclasifaux ,
                                           Integer.valueOf(AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels.size()) ,
                                           AV102Liquidacionverdetalle2ds_5_tfdconcodigo ,
                                           Integer.valueOf(AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels.size()) ,
                                           AV104Liquidacionverdetalle2ds_7_tfdcondescrip ,
                                           AV106Liquidacionverdetalle2ds_9_tfliqdvaluni ,
                                           AV107Liquidacionverdetalle2ds_10_tfliqdvaluni_to ,
                                           AV108Liquidacionverdetalle2ds_11_tfliqdimprecalcu ,
                                           AV109Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to ,
                                           Integer.valueOf(AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels.size()) ,
                                           AV110Liquidacionverdetalle2ds_13_tfliqderrordesc ,
                                           Byte.valueOf(A502LiqDMostrar) ,
                                           A277LiqDValUni ,
                                           A764LiqDImpReCalcu ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV47EmpCod) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(AV48LiqNro) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           Integer.valueOf(AV49LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV50CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV100Liquidacionverdetalle2ds_3_tfliqdclasifaux = GXutil.concat( GXutil.rtrim( AV100Liquidacionverdetalle2ds_3_tfliqdclasifaux), "%", "") ;
      lV102Liquidacionverdetalle2ds_5_tfdconcodigo = GXutil.padr( GXutil.rtrim( AV102Liquidacionverdetalle2ds_5_tfdconcodigo), 10, "%") ;
      lV104Liquidacionverdetalle2ds_7_tfdcondescrip = GXutil.concat( GXutil.rtrim( AV104Liquidacionverdetalle2ds_7_tfdcondescrip), "%", "") ;
      lV110Liquidacionverdetalle2ds_13_tfliqderrordesc = GXutil.concat( GXutil.rtrim( AV110Liquidacionverdetalle2ds_13_tfliqderrordesc), "%", "") ;
      /* Using cursor P01JB2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV47EmpCod), Integer.valueOf(AV48LiqNro), Integer.valueOf(AV49LegNumero), Integer.valueOf(AV50CliCod), lV100Liquidacionverdetalle2ds_3_tfliqdclasifaux, lV102Liquidacionverdetalle2ds_5_tfdconcodigo, lV104Liquidacionverdetalle2ds_7_tfdcondescrip, AV106Liquidacionverdetalle2ds_9_tfliqdvaluni, AV107Liquidacionverdetalle2ds_10_tfliqdvaluni_to, AV108Liquidacionverdetalle2ds_11_tfliqdimprecalcu, AV109Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to, lV110Liquidacionverdetalle2ds_13_tfliqderrordesc});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1JB2 = false ;
         A1EmpCod = P01JB2_A1EmpCod[0] ;
         A31LiqNro = P01JB2_A31LiqNro[0] ;
         A6LegNumero = P01JB2_A6LegNumero[0] ;
         A3CliCod = P01JB2_A3CliCod[0] ;
         A2149LiqDClasifAux = P01JB2_A2149LiqDClasifAux[0] ;
         A270LiqDErrorDesc = P01JB2_A270LiqDErrorDesc[0] ;
         n270LiqDErrorDesc = P01JB2_n270LiqDErrorDesc[0] ;
         A764LiqDImpReCalcu = P01JB2_A764LiqDImpReCalcu[0] ;
         A277LiqDValUni = P01JB2_A277LiqDValUni[0] ;
         n277LiqDValUni = P01JB2_n277LiqDValUni[0] ;
         A393DConDescrip = P01JB2_A393DConDescrip[0] ;
         A394DConCodigo = P01JB2_A394DConCodigo[0] ;
         A464DTipoConCod = P01JB2_A464DTipoConCod[0] ;
         A502LiqDMostrar = P01JB2_A502LiqDMostrar[0] ;
         A81LiqDSecuencial = P01JB2_A81LiqDSecuencial[0] ;
         AV41count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01JB2_A2149LiqDClasifAux[0], A2149LiqDClasifAux) == 0 ) )
         {
            brk1JB2 = false ;
            A1EmpCod = P01JB2_A1EmpCod[0] ;
            A31LiqNro = P01JB2_A31LiqNro[0] ;
            A6LegNumero = P01JB2_A6LegNumero[0] ;
            A3CliCod = P01JB2_A3CliCod[0] ;
            A81LiqDSecuencial = P01JB2_A81LiqDSecuencial[0] ;
            AV41count = (long)(AV41count+1) ;
            brk1JB2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A2149LiqDClasifAux)==0) )
         {
            AV33Option = A2149LiqDClasifAux ;
            AV34Options.add(AV33Option, 0);
            AV39OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV41count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1JB2 )
         {
            brk1JB2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADDCONCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV14TFDConCodigo = AV29SearchTxt ;
      AV15TFDConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV98Liquidacionverdetalle2ds_1_mostrar = AV88Mostrar ;
      AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels = AV12TFDTipoConCod_Sels ;
      AV100Liquidacionverdetalle2ds_3_tfliqdclasifaux = AV91TFLiqDClasifAux ;
      AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels = AV92TFLiqDClasifAux_Sels ;
      AV102Liquidacionverdetalle2ds_5_tfdconcodigo = AV14TFDConCodigo ;
      AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels = AV15TFDConCodigo_Sels ;
      AV104Liquidacionverdetalle2ds_7_tfdcondescrip = AV17TFDConDescrip ;
      AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels = AV18TFDConDescrip_Sels ;
      AV106Liquidacionverdetalle2ds_9_tfliqdvaluni = AV19TFLiqDValUni ;
      AV107Liquidacionverdetalle2ds_10_tfliqdvaluni_to = AV20TFLiqDValUni_To ;
      AV108Liquidacionverdetalle2ds_11_tfliqdimprecalcu = AV58TFLiqDImpReCalcu ;
      AV109Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to = AV59TFLiqDImpReCalcu_To ;
      AV110Liquidacionverdetalle2ds_13_tfliqderrordesc = AV27TFLiqDErrorDesc ;
      AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels = AV28TFLiqDErrorDesc_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A464DTipoConCod ,
                                           AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels ,
                                           A2149LiqDClasifAux ,
                                           AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels ,
                                           A394DConCodigo ,
                                           AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels ,
                                           A393DConDescrip ,
                                           AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels ,
                                           A270LiqDErrorDesc ,
                                           AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels ,
                                           AV98Liquidacionverdetalle2ds_1_mostrar ,
                                           Integer.valueOf(AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels.size()) ,
                                           Integer.valueOf(AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels.size()) ,
                                           AV100Liquidacionverdetalle2ds_3_tfliqdclasifaux ,
                                           Integer.valueOf(AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels.size()) ,
                                           AV102Liquidacionverdetalle2ds_5_tfdconcodigo ,
                                           Integer.valueOf(AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels.size()) ,
                                           AV104Liquidacionverdetalle2ds_7_tfdcondescrip ,
                                           AV106Liquidacionverdetalle2ds_9_tfliqdvaluni ,
                                           AV107Liquidacionverdetalle2ds_10_tfliqdvaluni_to ,
                                           AV108Liquidacionverdetalle2ds_11_tfliqdimprecalcu ,
                                           AV109Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to ,
                                           Integer.valueOf(AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels.size()) ,
                                           AV110Liquidacionverdetalle2ds_13_tfliqderrordesc ,
                                           Byte.valueOf(A502LiqDMostrar) ,
                                           A277LiqDValUni ,
                                           A764LiqDImpReCalcu ,
                                           Integer.valueOf(AV50CliCod) ,
                                           Short.valueOf(AV47EmpCod) ,
                                           Integer.valueOf(AV48LiqNro) ,
                                           Integer.valueOf(AV49LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV100Liquidacionverdetalle2ds_3_tfliqdclasifaux = GXutil.concat( GXutil.rtrim( AV100Liquidacionverdetalle2ds_3_tfliqdclasifaux), "%", "") ;
      lV102Liquidacionverdetalle2ds_5_tfdconcodigo = GXutil.padr( GXutil.rtrim( AV102Liquidacionverdetalle2ds_5_tfdconcodigo), 10, "%") ;
      lV104Liquidacionverdetalle2ds_7_tfdcondescrip = GXutil.concat( GXutil.rtrim( AV104Liquidacionverdetalle2ds_7_tfdcondescrip), "%", "") ;
      lV110Liquidacionverdetalle2ds_13_tfliqderrordesc = GXutil.concat( GXutil.rtrim( AV110Liquidacionverdetalle2ds_13_tfliqderrordesc), "%", "") ;
      /* Using cursor P01JB3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV50CliCod), Short.valueOf(AV47EmpCod), Integer.valueOf(AV48LiqNro), Integer.valueOf(AV49LegNumero), lV100Liquidacionverdetalle2ds_3_tfliqdclasifaux, lV102Liquidacionverdetalle2ds_5_tfdconcodigo, lV104Liquidacionverdetalle2ds_7_tfdcondescrip, AV106Liquidacionverdetalle2ds_9_tfliqdvaluni, AV107Liquidacionverdetalle2ds_10_tfliqdvaluni_to, AV108Liquidacionverdetalle2ds_11_tfliqdimprecalcu, AV109Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to, lV110Liquidacionverdetalle2ds_13_tfliqderrordesc});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1JB4 = false ;
         A6LegNumero = P01JB3_A6LegNumero[0] ;
         A31LiqNro = P01JB3_A31LiqNro[0] ;
         A1EmpCod = P01JB3_A1EmpCod[0] ;
         A3CliCod = P01JB3_A3CliCod[0] ;
         A394DConCodigo = P01JB3_A394DConCodigo[0] ;
         A270LiqDErrorDesc = P01JB3_A270LiqDErrorDesc[0] ;
         n270LiqDErrorDesc = P01JB3_n270LiqDErrorDesc[0] ;
         A764LiqDImpReCalcu = P01JB3_A764LiqDImpReCalcu[0] ;
         A277LiqDValUni = P01JB3_A277LiqDValUni[0] ;
         n277LiqDValUni = P01JB3_n277LiqDValUni[0] ;
         A393DConDescrip = P01JB3_A393DConDescrip[0] ;
         A2149LiqDClasifAux = P01JB3_A2149LiqDClasifAux[0] ;
         A464DTipoConCod = P01JB3_A464DTipoConCod[0] ;
         A502LiqDMostrar = P01JB3_A502LiqDMostrar[0] ;
         A81LiqDSecuencial = P01JB3_A81LiqDSecuencial[0] ;
         AV41count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P01JB3_A3CliCod[0] == A3CliCod ) && ( P01JB3_A1EmpCod[0] == A1EmpCod ) && ( P01JB3_A31LiqNro[0] == A31LiqNro ) && ( P01JB3_A6LegNumero[0] == A6LegNumero ) )
         {
            if ( ! ( ( GXutil.strcmp(P01JB3_A394DConCodigo[0], A394DConCodigo) == 0 ) ) )
            {
               if (true) break;
            }
            brk1JB4 = false ;
            A81LiqDSecuencial = P01JB3_A81LiqDSecuencial[0] ;
            AV41count = (long)(AV41count+1) ;
            brk1JB4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A394DConCodigo)==0) )
         {
            AV33Option = A394DConCodigo ;
            AV34Options.add(AV33Option, 0);
            AV39OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV41count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1JB4 )
         {
            brk1JB4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADDCONDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV17TFDConDescrip = AV29SearchTxt ;
      AV18TFDConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV98Liquidacionverdetalle2ds_1_mostrar = AV88Mostrar ;
      AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels = AV12TFDTipoConCod_Sels ;
      AV100Liquidacionverdetalle2ds_3_tfliqdclasifaux = AV91TFLiqDClasifAux ;
      AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels = AV92TFLiqDClasifAux_Sels ;
      AV102Liquidacionverdetalle2ds_5_tfdconcodigo = AV14TFDConCodigo ;
      AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels = AV15TFDConCodigo_Sels ;
      AV104Liquidacionverdetalle2ds_7_tfdcondescrip = AV17TFDConDescrip ;
      AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels = AV18TFDConDescrip_Sels ;
      AV106Liquidacionverdetalle2ds_9_tfliqdvaluni = AV19TFLiqDValUni ;
      AV107Liquidacionverdetalle2ds_10_tfliqdvaluni_to = AV20TFLiqDValUni_To ;
      AV108Liquidacionverdetalle2ds_11_tfliqdimprecalcu = AV58TFLiqDImpReCalcu ;
      AV109Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to = AV59TFLiqDImpReCalcu_To ;
      AV110Liquidacionverdetalle2ds_13_tfliqderrordesc = AV27TFLiqDErrorDesc ;
      AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels = AV28TFLiqDErrorDesc_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A464DTipoConCod ,
                                           AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels ,
                                           A2149LiqDClasifAux ,
                                           AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels ,
                                           A394DConCodigo ,
                                           AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels ,
                                           A393DConDescrip ,
                                           AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels ,
                                           A270LiqDErrorDesc ,
                                           AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels ,
                                           AV98Liquidacionverdetalle2ds_1_mostrar ,
                                           Integer.valueOf(AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels.size()) ,
                                           Integer.valueOf(AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels.size()) ,
                                           AV100Liquidacionverdetalle2ds_3_tfliqdclasifaux ,
                                           Integer.valueOf(AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels.size()) ,
                                           AV102Liquidacionverdetalle2ds_5_tfdconcodigo ,
                                           Integer.valueOf(AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels.size()) ,
                                           AV104Liquidacionverdetalle2ds_7_tfdcondescrip ,
                                           AV106Liquidacionverdetalle2ds_9_tfliqdvaluni ,
                                           AV107Liquidacionverdetalle2ds_10_tfliqdvaluni_to ,
                                           AV108Liquidacionverdetalle2ds_11_tfliqdimprecalcu ,
                                           AV109Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to ,
                                           Integer.valueOf(AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels.size()) ,
                                           AV110Liquidacionverdetalle2ds_13_tfliqderrordesc ,
                                           Byte.valueOf(A502LiqDMostrar) ,
                                           A277LiqDValUni ,
                                           A764LiqDImpReCalcu ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV47EmpCod) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(AV48LiqNro) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           Integer.valueOf(AV49LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV50CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV100Liquidacionverdetalle2ds_3_tfliqdclasifaux = GXutil.concat( GXutil.rtrim( AV100Liquidacionverdetalle2ds_3_tfliqdclasifaux), "%", "") ;
      lV102Liquidacionverdetalle2ds_5_tfdconcodigo = GXutil.padr( GXutil.rtrim( AV102Liquidacionverdetalle2ds_5_tfdconcodigo), 10, "%") ;
      lV104Liquidacionverdetalle2ds_7_tfdcondescrip = GXutil.concat( GXutil.rtrim( AV104Liquidacionverdetalle2ds_7_tfdcondescrip), "%", "") ;
      lV110Liquidacionverdetalle2ds_13_tfliqderrordesc = GXutil.concat( GXutil.rtrim( AV110Liquidacionverdetalle2ds_13_tfliqderrordesc), "%", "") ;
      /* Using cursor P01JB4 */
      pr_default.execute(2, new Object[] {Short.valueOf(AV47EmpCod), Integer.valueOf(AV48LiqNro), Integer.valueOf(AV49LegNumero), Integer.valueOf(AV50CliCod), lV100Liquidacionverdetalle2ds_3_tfliqdclasifaux, lV102Liquidacionverdetalle2ds_5_tfdconcodigo, lV104Liquidacionverdetalle2ds_7_tfdcondescrip, AV106Liquidacionverdetalle2ds_9_tfliqdvaluni, AV107Liquidacionverdetalle2ds_10_tfliqdvaluni_to, AV108Liquidacionverdetalle2ds_11_tfliqdimprecalcu, AV109Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to, lV110Liquidacionverdetalle2ds_13_tfliqderrordesc});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk1JB6 = false ;
         A1EmpCod = P01JB4_A1EmpCod[0] ;
         A31LiqNro = P01JB4_A31LiqNro[0] ;
         A6LegNumero = P01JB4_A6LegNumero[0] ;
         A3CliCod = P01JB4_A3CliCod[0] ;
         A393DConDescrip = P01JB4_A393DConDescrip[0] ;
         A270LiqDErrorDesc = P01JB4_A270LiqDErrorDesc[0] ;
         n270LiqDErrorDesc = P01JB4_n270LiqDErrorDesc[0] ;
         A764LiqDImpReCalcu = P01JB4_A764LiqDImpReCalcu[0] ;
         A277LiqDValUni = P01JB4_A277LiqDValUni[0] ;
         n277LiqDValUni = P01JB4_n277LiqDValUni[0] ;
         A394DConCodigo = P01JB4_A394DConCodigo[0] ;
         A2149LiqDClasifAux = P01JB4_A2149LiqDClasifAux[0] ;
         A464DTipoConCod = P01JB4_A464DTipoConCod[0] ;
         A502LiqDMostrar = P01JB4_A502LiqDMostrar[0] ;
         A81LiqDSecuencial = P01JB4_A81LiqDSecuencial[0] ;
         AV41count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P01JB4_A393DConDescrip[0], A393DConDescrip) == 0 ) )
         {
            brk1JB6 = false ;
            A1EmpCod = P01JB4_A1EmpCod[0] ;
            A31LiqNro = P01JB4_A31LiqNro[0] ;
            A6LegNumero = P01JB4_A6LegNumero[0] ;
            A3CliCod = P01JB4_A3CliCod[0] ;
            A81LiqDSecuencial = P01JB4_A81LiqDSecuencial[0] ;
            AV41count = (long)(AV41count+1) ;
            brk1JB6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A393DConDescrip)==0) )
         {
            AV33Option = A393DConDescrip ;
            AV34Options.add(AV33Option, 0);
            AV39OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV41count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1JB6 )
         {
            brk1JB6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADLIQDERRORDESCOPTIONS' Routine */
      returnInSub = false ;
      AV27TFLiqDErrorDesc = AV29SearchTxt ;
      AV28TFLiqDErrorDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV98Liquidacionverdetalle2ds_1_mostrar = AV88Mostrar ;
      AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels = AV12TFDTipoConCod_Sels ;
      AV100Liquidacionverdetalle2ds_3_tfliqdclasifaux = AV91TFLiqDClasifAux ;
      AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels = AV92TFLiqDClasifAux_Sels ;
      AV102Liquidacionverdetalle2ds_5_tfdconcodigo = AV14TFDConCodigo ;
      AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels = AV15TFDConCodigo_Sels ;
      AV104Liquidacionverdetalle2ds_7_tfdcondescrip = AV17TFDConDescrip ;
      AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels = AV18TFDConDescrip_Sels ;
      AV106Liquidacionverdetalle2ds_9_tfliqdvaluni = AV19TFLiqDValUni ;
      AV107Liquidacionverdetalle2ds_10_tfliqdvaluni_to = AV20TFLiqDValUni_To ;
      AV108Liquidacionverdetalle2ds_11_tfliqdimprecalcu = AV58TFLiqDImpReCalcu ;
      AV109Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to = AV59TFLiqDImpReCalcu_To ;
      AV110Liquidacionverdetalle2ds_13_tfliqderrordesc = AV27TFLiqDErrorDesc ;
      AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels = AV28TFLiqDErrorDesc_Sels ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A464DTipoConCod ,
                                           AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels ,
                                           A2149LiqDClasifAux ,
                                           AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels ,
                                           A394DConCodigo ,
                                           AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels ,
                                           A393DConDescrip ,
                                           AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels ,
                                           A270LiqDErrorDesc ,
                                           AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels ,
                                           AV98Liquidacionverdetalle2ds_1_mostrar ,
                                           Integer.valueOf(AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels.size()) ,
                                           Integer.valueOf(AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels.size()) ,
                                           AV100Liquidacionverdetalle2ds_3_tfliqdclasifaux ,
                                           Integer.valueOf(AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels.size()) ,
                                           AV102Liquidacionverdetalle2ds_5_tfdconcodigo ,
                                           Integer.valueOf(AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels.size()) ,
                                           AV104Liquidacionverdetalle2ds_7_tfdcondescrip ,
                                           AV106Liquidacionverdetalle2ds_9_tfliqdvaluni ,
                                           AV107Liquidacionverdetalle2ds_10_tfliqdvaluni_to ,
                                           AV108Liquidacionverdetalle2ds_11_tfliqdimprecalcu ,
                                           AV109Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to ,
                                           Integer.valueOf(AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels.size()) ,
                                           AV110Liquidacionverdetalle2ds_13_tfliqderrordesc ,
                                           Byte.valueOf(A502LiqDMostrar) ,
                                           A277LiqDValUni ,
                                           A764LiqDImpReCalcu ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV47EmpCod) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(AV48LiqNro) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           Integer.valueOf(AV49LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV50CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV100Liquidacionverdetalle2ds_3_tfliqdclasifaux = GXutil.concat( GXutil.rtrim( AV100Liquidacionverdetalle2ds_3_tfliqdclasifaux), "%", "") ;
      lV102Liquidacionverdetalle2ds_5_tfdconcodigo = GXutil.padr( GXutil.rtrim( AV102Liquidacionverdetalle2ds_5_tfdconcodigo), 10, "%") ;
      lV104Liquidacionverdetalle2ds_7_tfdcondescrip = GXutil.concat( GXutil.rtrim( AV104Liquidacionverdetalle2ds_7_tfdcondescrip), "%", "") ;
      lV110Liquidacionverdetalle2ds_13_tfliqderrordesc = GXutil.concat( GXutil.rtrim( AV110Liquidacionverdetalle2ds_13_tfliqderrordesc), "%", "") ;
      /* Using cursor P01JB5 */
      pr_default.execute(3, new Object[] {Short.valueOf(AV47EmpCod), Integer.valueOf(AV48LiqNro), Integer.valueOf(AV49LegNumero), Integer.valueOf(AV50CliCod), lV100Liquidacionverdetalle2ds_3_tfliqdclasifaux, lV102Liquidacionverdetalle2ds_5_tfdconcodigo, lV104Liquidacionverdetalle2ds_7_tfdcondescrip, AV106Liquidacionverdetalle2ds_9_tfliqdvaluni, AV107Liquidacionverdetalle2ds_10_tfliqdvaluni_to, AV108Liquidacionverdetalle2ds_11_tfliqdimprecalcu, AV109Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to, lV110Liquidacionverdetalle2ds_13_tfliqderrordesc});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk1JB8 = false ;
         A1EmpCod = P01JB5_A1EmpCod[0] ;
         A31LiqNro = P01JB5_A31LiqNro[0] ;
         A6LegNumero = P01JB5_A6LegNumero[0] ;
         A3CliCod = P01JB5_A3CliCod[0] ;
         A270LiqDErrorDesc = P01JB5_A270LiqDErrorDesc[0] ;
         n270LiqDErrorDesc = P01JB5_n270LiqDErrorDesc[0] ;
         A764LiqDImpReCalcu = P01JB5_A764LiqDImpReCalcu[0] ;
         A277LiqDValUni = P01JB5_A277LiqDValUni[0] ;
         n277LiqDValUni = P01JB5_n277LiqDValUni[0] ;
         A393DConDescrip = P01JB5_A393DConDescrip[0] ;
         A394DConCodigo = P01JB5_A394DConCodigo[0] ;
         A2149LiqDClasifAux = P01JB5_A2149LiqDClasifAux[0] ;
         A464DTipoConCod = P01JB5_A464DTipoConCod[0] ;
         A502LiqDMostrar = P01JB5_A502LiqDMostrar[0] ;
         A81LiqDSecuencial = P01JB5_A81LiqDSecuencial[0] ;
         AV41count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P01JB5_A270LiqDErrorDesc[0], A270LiqDErrorDesc) == 0 ) )
         {
            brk1JB8 = false ;
            A1EmpCod = P01JB5_A1EmpCod[0] ;
            A31LiqNro = P01JB5_A31LiqNro[0] ;
            A6LegNumero = P01JB5_A6LegNumero[0] ;
            A3CliCod = P01JB5_A3CliCod[0] ;
            A81LiqDSecuencial = P01JB5_A81LiqDSecuencial[0] ;
            AV41count = (long)(AV41count+1) ;
            brk1JB8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A270LiqDErrorDesc)==0) )
         {
            AV33Option = A270LiqDErrorDesc ;
            AV34Options.add(AV33Option, 0);
            AV39OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV41count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV34Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1JB8 )
         {
            brk1JB8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   protected void cleanup( )
   {
      this.aP3[0] = liquidacionverdetalle2getfilterdata.this.AV35OptionsJson;
      this.aP4[0] = liquidacionverdetalle2getfilterdata.this.AV38OptionsDescJson;
      this.aP5[0] = liquidacionverdetalle2getfilterdata.this.AV40OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV35OptionsJson = "" ;
      AV38OptionsDescJson = "" ;
      AV40OptionIndexesJson = "" ;
      GXv_int2 = new int[1] ;
      AV34Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV37OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean4 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV42Session = httpContext.getWebSession();
      AV44GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV45GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV88Mostrar = "" ;
      AV11TFDTipoConCod_SelsJson = "" ;
      AV12TFDTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV91TFLiqDClasifAux = "" ;
      AV90TFLiqDClasifAux_SelsJson = "" ;
      AV92TFLiqDClasifAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14TFDConCodigo = "" ;
      AV13TFDConCodigo_SelsJson = "" ;
      AV15TFDConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV17TFDConDescrip = "" ;
      AV16TFDConDescrip_SelsJson = "" ;
      AV18TFDConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19TFLiqDValUni = DecimalUtil.ZERO ;
      AV20TFLiqDValUni_To = DecimalUtil.ZERO ;
      AV58TFLiqDImpReCalcu = DecimalUtil.ZERO ;
      AV59TFLiqDImpReCalcu_To = DecimalUtil.ZERO ;
      AV27TFLiqDErrorDesc = "" ;
      AV26TFLiqDErrorDesc_SelsJson = "" ;
      AV28TFLiqDErrorDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV93auxMenuOpcCod = "" ;
      A2149LiqDClasifAux = "" ;
      AV98Liquidacionverdetalle2ds_1_mostrar = "" ;
      AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV100Liquidacionverdetalle2ds_3_tfliqdclasifaux = "" ;
      AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV102Liquidacionverdetalle2ds_5_tfdconcodigo = "" ;
      AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV104Liquidacionverdetalle2ds_7_tfdcondescrip = "" ;
      AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV106Liquidacionverdetalle2ds_9_tfliqdvaluni = DecimalUtil.ZERO ;
      AV107Liquidacionverdetalle2ds_10_tfliqdvaluni_to = DecimalUtil.ZERO ;
      AV108Liquidacionverdetalle2ds_11_tfliqdimprecalcu = DecimalUtil.ZERO ;
      AV109Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to = DecimalUtil.ZERO ;
      AV110Liquidacionverdetalle2ds_13_tfliqderrordesc = "" ;
      AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV100Liquidacionverdetalle2ds_3_tfliqdclasifaux = "" ;
      lV102Liquidacionverdetalle2ds_5_tfdconcodigo = "" ;
      lV104Liquidacionverdetalle2ds_7_tfdcondescrip = "" ;
      lV110Liquidacionverdetalle2ds_13_tfliqderrordesc = "" ;
      A464DTipoConCod = "" ;
      A394DConCodigo = "" ;
      A393DConDescrip = "" ;
      A270LiqDErrorDesc = "" ;
      A277LiqDValUni = DecimalUtil.ZERO ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      P01JB2_A1EmpCod = new short[1] ;
      P01JB2_A31LiqNro = new int[1] ;
      P01JB2_A6LegNumero = new int[1] ;
      P01JB2_A3CliCod = new int[1] ;
      P01JB2_A2149LiqDClasifAux = new String[] {""} ;
      P01JB2_A270LiqDErrorDesc = new String[] {""} ;
      P01JB2_n270LiqDErrorDesc = new boolean[] {false} ;
      P01JB2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01JB2_A277LiqDValUni = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01JB2_n277LiqDValUni = new boolean[] {false} ;
      P01JB2_A393DConDescrip = new String[] {""} ;
      P01JB2_A394DConCodigo = new String[] {""} ;
      P01JB2_A464DTipoConCod = new String[] {""} ;
      P01JB2_A502LiqDMostrar = new byte[1] ;
      P01JB2_A81LiqDSecuencial = new int[1] ;
      AV33Option = "" ;
      P01JB3_A6LegNumero = new int[1] ;
      P01JB3_A31LiqNro = new int[1] ;
      P01JB3_A1EmpCod = new short[1] ;
      P01JB3_A3CliCod = new int[1] ;
      P01JB3_A394DConCodigo = new String[] {""} ;
      P01JB3_A270LiqDErrorDesc = new String[] {""} ;
      P01JB3_n270LiqDErrorDesc = new boolean[] {false} ;
      P01JB3_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01JB3_A277LiqDValUni = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01JB3_n277LiqDValUni = new boolean[] {false} ;
      P01JB3_A393DConDescrip = new String[] {""} ;
      P01JB3_A2149LiqDClasifAux = new String[] {""} ;
      P01JB3_A464DTipoConCod = new String[] {""} ;
      P01JB3_A502LiqDMostrar = new byte[1] ;
      P01JB3_A81LiqDSecuencial = new int[1] ;
      P01JB4_A1EmpCod = new short[1] ;
      P01JB4_A31LiqNro = new int[1] ;
      P01JB4_A6LegNumero = new int[1] ;
      P01JB4_A3CliCod = new int[1] ;
      P01JB4_A393DConDescrip = new String[] {""} ;
      P01JB4_A270LiqDErrorDesc = new String[] {""} ;
      P01JB4_n270LiqDErrorDesc = new boolean[] {false} ;
      P01JB4_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01JB4_A277LiqDValUni = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01JB4_n277LiqDValUni = new boolean[] {false} ;
      P01JB4_A394DConCodigo = new String[] {""} ;
      P01JB4_A2149LiqDClasifAux = new String[] {""} ;
      P01JB4_A464DTipoConCod = new String[] {""} ;
      P01JB4_A502LiqDMostrar = new byte[1] ;
      P01JB4_A81LiqDSecuencial = new int[1] ;
      P01JB5_A1EmpCod = new short[1] ;
      P01JB5_A31LiqNro = new int[1] ;
      P01JB5_A6LegNumero = new int[1] ;
      P01JB5_A3CliCod = new int[1] ;
      P01JB5_A270LiqDErrorDesc = new String[] {""} ;
      P01JB5_n270LiqDErrorDesc = new boolean[] {false} ;
      P01JB5_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01JB5_A277LiqDValUni = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01JB5_n277LiqDValUni = new boolean[] {false} ;
      P01JB5_A393DConDescrip = new String[] {""} ;
      P01JB5_A394DConCodigo = new String[] {""} ;
      P01JB5_A2149LiqDClasifAux = new String[] {""} ;
      P01JB5_A464DTipoConCod = new String[] {""} ;
      P01JB5_A502LiqDMostrar = new byte[1] ;
      P01JB5_A81LiqDSecuencial = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacionverdetalle2getfilterdata__default(),
         new Object[] {
             new Object[] {
            P01JB2_A1EmpCod, P01JB2_A31LiqNro, P01JB2_A6LegNumero, P01JB2_A3CliCod, P01JB2_A2149LiqDClasifAux, P01JB2_A270LiqDErrorDesc, P01JB2_n270LiqDErrorDesc, P01JB2_A764LiqDImpReCalcu, P01JB2_A277LiqDValUni, P01JB2_n277LiqDValUni,
            P01JB2_A393DConDescrip, P01JB2_A394DConCodigo, P01JB2_A464DTipoConCod, P01JB2_A502LiqDMostrar, P01JB2_A81LiqDSecuencial
            }
            , new Object[] {
            P01JB3_A6LegNumero, P01JB3_A31LiqNro, P01JB3_A1EmpCod, P01JB3_A3CliCod, P01JB3_A394DConCodigo, P01JB3_A270LiqDErrorDesc, P01JB3_n270LiqDErrorDesc, P01JB3_A764LiqDImpReCalcu, P01JB3_A277LiqDValUni, P01JB3_n277LiqDValUni,
            P01JB3_A393DConDescrip, P01JB3_A2149LiqDClasifAux, P01JB3_A464DTipoConCod, P01JB3_A502LiqDMostrar, P01JB3_A81LiqDSecuencial
            }
            , new Object[] {
            P01JB4_A1EmpCod, P01JB4_A31LiqNro, P01JB4_A6LegNumero, P01JB4_A3CliCod, P01JB4_A393DConDescrip, P01JB4_A270LiqDErrorDesc, P01JB4_n270LiqDErrorDesc, P01JB4_A764LiqDImpReCalcu, P01JB4_A277LiqDValUni, P01JB4_n277LiqDValUni,
            P01JB4_A394DConCodigo, P01JB4_A2149LiqDClasifAux, P01JB4_A464DTipoConCod, P01JB4_A502LiqDMostrar, P01JB4_A81LiqDSecuencial
            }
            , new Object[] {
            P01JB5_A1EmpCod, P01JB5_A31LiqNro, P01JB5_A6LegNumero, P01JB5_A3CliCod, P01JB5_A270LiqDErrorDesc, P01JB5_n270LiqDErrorDesc, P01JB5_A764LiqDImpReCalcu, P01JB5_A277LiqDValUni, P01JB5_n277LiqDValUni, P01JB5_A393DConDescrip,
            P01JB5_A394DConCodigo, P01JB5_A2149LiqDClasifAux, P01JB5_A464DTipoConCod, P01JB5_A502LiqDMostrar, P01JB5_A81LiqDSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A502LiqDMostrar ;
   private short AV47EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV50CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV96GXV1 ;
   private int AV48LiqNro ;
   private int AV49LegNumero ;
   private int AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels_size ;
   private int AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size ;
   private int AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size ;
   private int AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size ;
   private int AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private long AV41count ;
   private java.math.BigDecimal AV19TFLiqDValUni ;
   private java.math.BigDecimal AV20TFLiqDValUni_To ;
   private java.math.BigDecimal AV58TFLiqDImpReCalcu ;
   private java.math.BigDecimal AV59TFLiqDImpReCalcu_To ;
   private java.math.BigDecimal AV106Liquidacionverdetalle2ds_9_tfliqdvaluni ;
   private java.math.BigDecimal AV107Liquidacionverdetalle2ds_10_tfliqdvaluni_to ;
   private java.math.BigDecimal AV108Liquidacionverdetalle2ds_11_tfliqdimprecalcu ;
   private java.math.BigDecimal AV109Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to ;
   private java.math.BigDecimal A277LiqDValUni ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private String AV88Mostrar ;
   private String AV14TFDConCodigo ;
   private String AV98Liquidacionverdetalle2ds_1_mostrar ;
   private String AV102Liquidacionverdetalle2ds_5_tfdconcodigo ;
   private String scmdbuf ;
   private String lV102Liquidacionverdetalle2ds_5_tfdconcodigo ;
   private String A464DTipoConCod ;
   private String A394DConCodigo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private boolean returnInSub ;
   private boolean brk1JB2 ;
   private boolean n270LiqDErrorDesc ;
   private boolean n277LiqDValUni ;
   private boolean brk1JB4 ;
   private boolean brk1JB6 ;
   private boolean brk1JB8 ;
   private String AV35OptionsJson ;
   private String AV38OptionsDescJson ;
   private String AV40OptionIndexesJson ;
   private String AV11TFDTipoConCod_SelsJson ;
   private String AV90TFLiqDClasifAux_SelsJson ;
   private String AV13TFDConCodigo_SelsJson ;
   private String AV16TFDConDescrip_SelsJson ;
   private String AV26TFLiqDErrorDesc_SelsJson ;
   private String AV31DDOName ;
   private String AV29SearchTxt ;
   private String AV30SearchTxtTo ;
   private String AV91TFLiqDClasifAux ;
   private String AV17TFDConDescrip ;
   private String AV27TFLiqDErrorDesc ;
   private String AV93auxMenuOpcCod ;
   private String A2149LiqDClasifAux ;
   private String AV100Liquidacionverdetalle2ds_3_tfliqdclasifaux ;
   private String AV104Liquidacionverdetalle2ds_7_tfdcondescrip ;
   private String AV110Liquidacionverdetalle2ds_13_tfliqderrordesc ;
   private String lV100Liquidacionverdetalle2ds_3_tfliqdclasifaux ;
   private String lV104Liquidacionverdetalle2ds_7_tfdcondescrip ;
   private String lV110Liquidacionverdetalle2ds_13_tfliqderrordesc ;
   private String A393DConDescrip ;
   private String A270LiqDErrorDesc ;
   private String AV33Option ;
   private com.genexus.webpanels.WebSession AV42Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P01JB2_A1EmpCod ;
   private int[] P01JB2_A31LiqNro ;
   private int[] P01JB2_A6LegNumero ;
   private int[] P01JB2_A3CliCod ;
   private String[] P01JB2_A2149LiqDClasifAux ;
   private String[] P01JB2_A270LiqDErrorDesc ;
   private boolean[] P01JB2_n270LiqDErrorDesc ;
   private java.math.BigDecimal[] P01JB2_A764LiqDImpReCalcu ;
   private java.math.BigDecimal[] P01JB2_A277LiqDValUni ;
   private boolean[] P01JB2_n277LiqDValUni ;
   private String[] P01JB2_A393DConDescrip ;
   private String[] P01JB2_A394DConCodigo ;
   private String[] P01JB2_A464DTipoConCod ;
   private byte[] P01JB2_A502LiqDMostrar ;
   private int[] P01JB2_A81LiqDSecuencial ;
   private int[] P01JB3_A6LegNumero ;
   private int[] P01JB3_A31LiqNro ;
   private short[] P01JB3_A1EmpCod ;
   private int[] P01JB3_A3CliCod ;
   private String[] P01JB3_A394DConCodigo ;
   private String[] P01JB3_A270LiqDErrorDesc ;
   private boolean[] P01JB3_n270LiqDErrorDesc ;
   private java.math.BigDecimal[] P01JB3_A764LiqDImpReCalcu ;
   private java.math.BigDecimal[] P01JB3_A277LiqDValUni ;
   private boolean[] P01JB3_n277LiqDValUni ;
   private String[] P01JB3_A393DConDescrip ;
   private String[] P01JB3_A2149LiqDClasifAux ;
   private String[] P01JB3_A464DTipoConCod ;
   private byte[] P01JB3_A502LiqDMostrar ;
   private int[] P01JB3_A81LiqDSecuencial ;
   private short[] P01JB4_A1EmpCod ;
   private int[] P01JB4_A31LiqNro ;
   private int[] P01JB4_A6LegNumero ;
   private int[] P01JB4_A3CliCod ;
   private String[] P01JB4_A393DConDescrip ;
   private String[] P01JB4_A270LiqDErrorDesc ;
   private boolean[] P01JB4_n270LiqDErrorDesc ;
   private java.math.BigDecimal[] P01JB4_A764LiqDImpReCalcu ;
   private java.math.BigDecimal[] P01JB4_A277LiqDValUni ;
   private boolean[] P01JB4_n277LiqDValUni ;
   private String[] P01JB4_A394DConCodigo ;
   private String[] P01JB4_A2149LiqDClasifAux ;
   private String[] P01JB4_A464DTipoConCod ;
   private byte[] P01JB4_A502LiqDMostrar ;
   private int[] P01JB4_A81LiqDSecuencial ;
   private short[] P01JB5_A1EmpCod ;
   private int[] P01JB5_A31LiqNro ;
   private int[] P01JB5_A6LegNumero ;
   private int[] P01JB5_A3CliCod ;
   private String[] P01JB5_A270LiqDErrorDesc ;
   private boolean[] P01JB5_n270LiqDErrorDesc ;
   private java.math.BigDecimal[] P01JB5_A764LiqDImpReCalcu ;
   private java.math.BigDecimal[] P01JB5_A277LiqDValUni ;
   private boolean[] P01JB5_n277LiqDValUni ;
   private String[] P01JB5_A393DConDescrip ;
   private String[] P01JB5_A394DConCodigo ;
   private String[] P01JB5_A2149LiqDClasifAux ;
   private String[] P01JB5_A464DTipoConCod ;
   private byte[] P01JB5_A502LiqDMostrar ;
   private int[] P01JB5_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV12TFDTipoConCod_Sels ;
   private GXSimpleCollection<String> AV15TFDConCodigo_Sels ;
   private GXSimpleCollection<String> AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels ;
   private GXSimpleCollection<String> AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels ;
   private GXSimpleCollection<String> AV34Options ;
   private GXSimpleCollection<String> AV37OptionsDesc ;
   private GXSimpleCollection<String> AV39OptionIndexes ;
   private GXSimpleCollection<String> AV92TFLiqDClasifAux_Sels ;
   private GXSimpleCollection<String> AV18TFDConDescrip_Sels ;
   private GXSimpleCollection<String> AV28TFLiqDErrorDesc_Sels ;
   private GXSimpleCollection<String> AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels ;
   private GXSimpleCollection<String> AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels ;
   private GXSimpleCollection<String> AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV44GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV45GridStateFilterValue ;
}

final  class liquidacionverdetalle2getfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01JB2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels ,
                                          String A2149LiqDClasifAux ,
                                          GXSimpleCollection<String> AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels ,
                                          String A270LiqDErrorDesc ,
                                          GXSimpleCollection<String> AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels ,
                                          String AV98Liquidacionverdetalle2ds_1_mostrar ,
                                          int AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels_size ,
                                          int AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size ,
                                          String AV100Liquidacionverdetalle2ds_3_tfliqdclasifaux ,
                                          int AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size ,
                                          String AV102Liquidacionverdetalle2ds_5_tfdconcodigo ,
                                          int AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size ,
                                          String AV104Liquidacionverdetalle2ds_7_tfdcondescrip ,
                                          java.math.BigDecimal AV106Liquidacionverdetalle2ds_9_tfliqdvaluni ,
                                          java.math.BigDecimal AV107Liquidacionverdetalle2ds_10_tfliqdvaluni_to ,
                                          java.math.BigDecimal AV108Liquidacionverdetalle2ds_11_tfliqdimprecalcu ,
                                          java.math.BigDecimal AV109Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to ,
                                          int AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size ,
                                          String AV110Liquidacionverdetalle2ds_13_tfliqderrordesc ,
                                          byte A502LiqDMostrar ,
                                          java.math.BigDecimal A277LiqDValUni ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          short A1EmpCod ,
                                          short AV47EmpCod ,
                                          int A31LiqNro ,
                                          int AV48LiqNro ,
                                          int A6LegNumero ,
                                          int AV49LegNumero ,
                                          int A3CliCod ,
                                          int AV50CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[12];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT EmpCod, LiqNro, LegNumero, CliCod, LiqDClasifAux, LiqDErrorDesc, LiqDImpReCalcu, LiqDValUni, DConDescrip, DConCodigo, DTipoConCod, LiqDMostrar, LiqDSecuencial" ;
      scmdbuf += " FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(EmpCod = ?)");
      addWhere(sWhereString, "(LiqNro = ?)");
      addWhere(sWhereString, "(LegNumero = ?)");
      addWhere(sWhereString, "(CliCod = ?)");
      if ( GXutil.strcmp(AV98Liquidacionverdetalle2ds_1_mostrar, httpContext.getMessage( httpContext.getMessage( "RECIBO", ""), "")) == 0 )
      {
         addWhere(sWhereString, "(LiqDMostrar = 3)");
      }
      if ( AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels, "DTipoConCod IN (", ")")+")");
      }
      if ( ( AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV100Liquidacionverdetalle2ds_3_tfliqdclasifaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDClasifAux) like LOWER(?))");
      }
      else
      {
         GXv_int6[4] = (byte)(1) ;
      }
      if ( AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels, "LiqDClasifAux IN (", ")")+")");
      }
      if ( ( AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV102Liquidacionverdetalle2ds_5_tfdconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int6[5] = (byte)(1) ;
      }
      if ( AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels, "DConCodigo IN (", ")")+")");
      }
      if ( ( AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV104Liquidacionverdetalle2ds_7_tfdcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int6[6] = (byte)(1) ;
      }
      if ( AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels, "DConDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV106Liquidacionverdetalle2ds_9_tfliqdvaluni)==0) )
      {
         addWhere(sWhereString, "(LiqDValUni >= ?)");
      }
      else
      {
         GXv_int6[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV107Liquidacionverdetalle2ds_10_tfliqdvaluni_to)==0) )
      {
         addWhere(sWhereString, "(LiqDValUni <= ?)");
      }
      else
      {
         GXv_int6[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV108Liquidacionverdetalle2ds_11_tfliqdimprecalcu)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int6[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV109Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int6[10] = (byte)(1) ;
      }
      if ( ( AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV110Liquidacionverdetalle2ds_13_tfliqderrordesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDErrorDesc) like LOWER(?))");
      }
      else
      {
         GXv_int6[11] = (byte)(1) ;
      }
      if ( AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels, "LiqDErrorDesc IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY LiqDClasifAux" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   protected Object[] conditional_P01JB3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels ,
                                          String A2149LiqDClasifAux ,
                                          GXSimpleCollection<String> AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels ,
                                          String A270LiqDErrorDesc ,
                                          GXSimpleCollection<String> AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels ,
                                          String AV98Liquidacionverdetalle2ds_1_mostrar ,
                                          int AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels_size ,
                                          int AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size ,
                                          String AV100Liquidacionverdetalle2ds_3_tfliqdclasifaux ,
                                          int AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size ,
                                          String AV102Liquidacionverdetalle2ds_5_tfdconcodigo ,
                                          int AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size ,
                                          String AV104Liquidacionverdetalle2ds_7_tfdcondescrip ,
                                          java.math.BigDecimal AV106Liquidacionverdetalle2ds_9_tfliqdvaluni ,
                                          java.math.BigDecimal AV107Liquidacionverdetalle2ds_10_tfliqdvaluni_to ,
                                          java.math.BigDecimal AV108Liquidacionverdetalle2ds_11_tfliqdimprecalcu ,
                                          java.math.BigDecimal AV109Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to ,
                                          int AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size ,
                                          String AV110Liquidacionverdetalle2ds_13_tfliqderrordesc ,
                                          byte A502LiqDMostrar ,
                                          java.math.BigDecimal A277LiqDValUni ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          int AV50CliCod ,
                                          short AV47EmpCod ,
                                          int AV48LiqNro ,
                                          int AV49LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int9 = new byte[12];
      Object[] GXv_Object10 = new Object[2];
      scmdbuf = "SELECT LegNumero, LiqNro, EmpCod, CliCod, DConCodigo, LiqDErrorDesc, LiqDImpReCalcu, LiqDValUni, DConDescrip, LiqDClasifAux, DTipoConCod, LiqDMostrar, LiqDSecuencial" ;
      scmdbuf += " FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?)");
      if ( GXutil.strcmp(AV98Liquidacionverdetalle2ds_1_mostrar, httpContext.getMessage( httpContext.getMessage( "RECIBO", ""), "")) == 0 )
      {
         addWhere(sWhereString, "(LiqDMostrar = 3)");
      }
      if ( AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels, "DTipoConCod IN (", ")")+")");
      }
      if ( ( AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV100Liquidacionverdetalle2ds_3_tfliqdclasifaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDClasifAux) like LOWER(?))");
      }
      else
      {
         GXv_int9[4] = (byte)(1) ;
      }
      if ( AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels, "LiqDClasifAux IN (", ")")+")");
      }
      if ( ( AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV102Liquidacionverdetalle2ds_5_tfdconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int9[5] = (byte)(1) ;
      }
      if ( AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels, "DConCodigo IN (", ")")+")");
      }
      if ( ( AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV104Liquidacionverdetalle2ds_7_tfdcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int9[6] = (byte)(1) ;
      }
      if ( AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels, "DConDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV106Liquidacionverdetalle2ds_9_tfliqdvaluni)==0) )
      {
         addWhere(sWhereString, "(LiqDValUni >= ?)");
      }
      else
      {
         GXv_int9[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV107Liquidacionverdetalle2ds_10_tfliqdvaluni_to)==0) )
      {
         addWhere(sWhereString, "(LiqDValUni <= ?)");
      }
      else
      {
         GXv_int9[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV108Liquidacionverdetalle2ds_11_tfliqdimprecalcu)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int9[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV109Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int9[10] = (byte)(1) ;
      }
      if ( ( AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV110Liquidacionverdetalle2ds_13_tfliqderrordesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDErrorDesc) like LOWER(?))");
      }
      else
      {
         GXv_int9[11] = (byte)(1) ;
      }
      if ( AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels, "LiqDErrorDesc IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DConCodigo" ;
      GXv_Object10[0] = scmdbuf ;
      GXv_Object10[1] = GXv_int9 ;
      return GXv_Object10 ;
   }

   protected Object[] conditional_P01JB4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels ,
                                          String A2149LiqDClasifAux ,
                                          GXSimpleCollection<String> AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels ,
                                          String A270LiqDErrorDesc ,
                                          GXSimpleCollection<String> AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels ,
                                          String AV98Liquidacionverdetalle2ds_1_mostrar ,
                                          int AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels_size ,
                                          int AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size ,
                                          String AV100Liquidacionverdetalle2ds_3_tfliqdclasifaux ,
                                          int AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size ,
                                          String AV102Liquidacionverdetalle2ds_5_tfdconcodigo ,
                                          int AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size ,
                                          String AV104Liquidacionverdetalle2ds_7_tfdcondescrip ,
                                          java.math.BigDecimal AV106Liquidacionverdetalle2ds_9_tfliqdvaluni ,
                                          java.math.BigDecimal AV107Liquidacionverdetalle2ds_10_tfliqdvaluni_to ,
                                          java.math.BigDecimal AV108Liquidacionverdetalle2ds_11_tfliqdimprecalcu ,
                                          java.math.BigDecimal AV109Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to ,
                                          int AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size ,
                                          String AV110Liquidacionverdetalle2ds_13_tfliqderrordesc ,
                                          byte A502LiqDMostrar ,
                                          java.math.BigDecimal A277LiqDValUni ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          short A1EmpCod ,
                                          short AV47EmpCod ,
                                          int A31LiqNro ,
                                          int AV48LiqNro ,
                                          int A6LegNumero ,
                                          int AV49LegNumero ,
                                          int A3CliCod ,
                                          int AV50CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[12];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT EmpCod, LiqNro, LegNumero, CliCod, DConDescrip, LiqDErrorDesc, LiqDImpReCalcu, LiqDValUni, DConCodigo, LiqDClasifAux, DTipoConCod, LiqDMostrar, LiqDSecuencial" ;
      scmdbuf += " FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(EmpCod = ?)");
      addWhere(sWhereString, "(LiqNro = ?)");
      addWhere(sWhereString, "(LegNumero = ?)");
      addWhere(sWhereString, "(CliCod = ?)");
      if ( GXutil.strcmp(AV98Liquidacionverdetalle2ds_1_mostrar, httpContext.getMessage( httpContext.getMessage( "RECIBO", ""), "")) == 0 )
      {
         addWhere(sWhereString, "(LiqDMostrar = 3)");
      }
      if ( AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels, "DTipoConCod IN (", ")")+")");
      }
      if ( ( AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV100Liquidacionverdetalle2ds_3_tfliqdclasifaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDClasifAux) like LOWER(?))");
      }
      else
      {
         GXv_int12[4] = (byte)(1) ;
      }
      if ( AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels, "LiqDClasifAux IN (", ")")+")");
      }
      if ( ( AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV102Liquidacionverdetalle2ds_5_tfdconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int12[5] = (byte)(1) ;
      }
      if ( AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels, "DConCodigo IN (", ")")+")");
      }
      if ( ( AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV104Liquidacionverdetalle2ds_7_tfdcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int12[6] = (byte)(1) ;
      }
      if ( AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels, "DConDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV106Liquidacionverdetalle2ds_9_tfliqdvaluni)==0) )
      {
         addWhere(sWhereString, "(LiqDValUni >= ?)");
      }
      else
      {
         GXv_int12[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV107Liquidacionverdetalle2ds_10_tfliqdvaluni_to)==0) )
      {
         addWhere(sWhereString, "(LiqDValUni <= ?)");
      }
      else
      {
         GXv_int12[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV108Liquidacionverdetalle2ds_11_tfliqdimprecalcu)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int12[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV109Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int12[10] = (byte)(1) ;
      }
      if ( ( AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV110Liquidacionverdetalle2ds_13_tfliqderrordesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDErrorDesc) like LOWER(?))");
      }
      else
      {
         GXv_int12[11] = (byte)(1) ;
      }
      if ( AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels, "LiqDErrorDesc IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY DConDescrip" ;
      GXv_Object13[0] = scmdbuf ;
      GXv_Object13[1] = GXv_int12 ;
      return GXv_Object13 ;
   }

   protected Object[] conditional_P01JB5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels ,
                                          String A2149LiqDClasifAux ,
                                          GXSimpleCollection<String> AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels ,
                                          String A270LiqDErrorDesc ,
                                          GXSimpleCollection<String> AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels ,
                                          String AV98Liquidacionverdetalle2ds_1_mostrar ,
                                          int AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels_size ,
                                          int AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size ,
                                          String AV100Liquidacionverdetalle2ds_3_tfliqdclasifaux ,
                                          int AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size ,
                                          String AV102Liquidacionverdetalle2ds_5_tfdconcodigo ,
                                          int AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size ,
                                          String AV104Liquidacionverdetalle2ds_7_tfdcondescrip ,
                                          java.math.BigDecimal AV106Liquidacionverdetalle2ds_9_tfliqdvaluni ,
                                          java.math.BigDecimal AV107Liquidacionverdetalle2ds_10_tfliqdvaluni_to ,
                                          java.math.BigDecimal AV108Liquidacionverdetalle2ds_11_tfliqdimprecalcu ,
                                          java.math.BigDecimal AV109Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to ,
                                          int AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size ,
                                          String AV110Liquidacionverdetalle2ds_13_tfliqderrordesc ,
                                          byte A502LiqDMostrar ,
                                          java.math.BigDecimal A277LiqDValUni ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          short A1EmpCod ,
                                          short AV47EmpCod ,
                                          int A31LiqNro ,
                                          int AV48LiqNro ,
                                          int A6LegNumero ,
                                          int AV49LegNumero ,
                                          int A3CliCod ,
                                          int AV50CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int15 = new byte[12];
      Object[] GXv_Object16 = new Object[2];
      scmdbuf = "SELECT EmpCod, LiqNro, LegNumero, CliCod, LiqDErrorDesc, LiqDImpReCalcu, LiqDValUni, DConDescrip, DConCodigo, LiqDClasifAux, DTipoConCod, LiqDMostrar, LiqDSecuencial" ;
      scmdbuf += " FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(EmpCod = ?)");
      addWhere(sWhereString, "(LiqNro = ?)");
      addWhere(sWhereString, "(LegNumero = ?)");
      addWhere(sWhereString, "(CliCod = ?)");
      if ( GXutil.strcmp(AV98Liquidacionverdetalle2ds_1_mostrar, httpContext.getMessage( httpContext.getMessage( "RECIBO", ""), "")) == 0 )
      {
         addWhere(sWhereString, "(LiqDMostrar = 3)");
      }
      if ( AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV99Liquidacionverdetalle2ds_2_tfdtipoconcod_sels, "DTipoConCod IN (", ")")+")");
      }
      if ( ( AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV100Liquidacionverdetalle2ds_3_tfliqdclasifaux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDClasifAux) like LOWER(?))");
      }
      else
      {
         GXv_int15[4] = (byte)(1) ;
      }
      if ( AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV101Liquidacionverdetalle2ds_4_tfliqdclasifaux_sels, "LiqDClasifAux IN (", ")")+")");
      }
      if ( ( AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV102Liquidacionverdetalle2ds_5_tfdconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int15[5] = (byte)(1) ;
      }
      if ( AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV103Liquidacionverdetalle2ds_6_tfdconcodigo_sels, "DConCodigo IN (", ")")+")");
      }
      if ( ( AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV104Liquidacionverdetalle2ds_7_tfdcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int15[6] = (byte)(1) ;
      }
      if ( AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV105Liquidacionverdetalle2ds_8_tfdcondescrip_sels, "DConDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV106Liquidacionverdetalle2ds_9_tfliqdvaluni)==0) )
      {
         addWhere(sWhereString, "(LiqDValUni >= ?)");
      }
      else
      {
         GXv_int15[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV107Liquidacionverdetalle2ds_10_tfliqdvaluni_to)==0) )
      {
         addWhere(sWhereString, "(LiqDValUni <= ?)");
      }
      else
      {
         GXv_int15[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV108Liquidacionverdetalle2ds_11_tfliqdimprecalcu)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int15[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV109Liquidacionverdetalle2ds_12_tfliqdimprecalcu_to)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int15[10] = (byte)(1) ;
      }
      if ( ( AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV110Liquidacionverdetalle2ds_13_tfliqderrordesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqDErrorDesc) like LOWER(?))");
      }
      else
      {
         GXv_int15[11] = (byte)(1) ;
      }
      if ( AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV111Liquidacionverdetalle2ds_14_tfliqderrordesc_sels, "LiqDErrorDesc IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY LiqDErrorDesc" ;
      GXv_Object16[0] = scmdbuf ;
      GXv_Object16[1] = GXv_int15 ;
      return GXv_Object16 ;
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
                  return conditional_P01JB2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , ((Number) dynConstraints[27]).shortValue() , ((Number) dynConstraints[28]).shortValue() , ((Number) dynConstraints[29]).intValue() , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).intValue() );
            case 1 :
                  return conditional_P01JB3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).shortValue() , ((Number) dynConstraints[29]).intValue() , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).intValue() );
            case 2 :
                  return conditional_P01JB4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , ((Number) dynConstraints[27]).shortValue() , ((Number) dynConstraints[28]).shortValue() , ((Number) dynConstraints[29]).intValue() , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).intValue() );
            case 3 :
                  return conditional_P01JB5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , ((Number) dynConstraints[27]).shortValue() , ((Number) dynConstraints[28]).shortValue() , ((Number) dynConstraints[29]).intValue() , ((Number) dynConstraints[30]).intValue() , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01JB2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01JB3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01JB4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01JB5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               ((String[]) buf[11])[0] = rslt.getString(10, 10);
               ((String[]) buf[12])[0] = rslt.getString(11, 20);
               ((byte[]) buf[13])[0] = rslt.getByte(12);
               ((int[]) buf[14])[0] = rslt.getInt(13);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               ((String[]) buf[11])[0] = rslt.getVarchar(10);
               ((String[]) buf[12])[0] = rslt.getString(11, 20);
               ((byte[]) buf[13])[0] = rslt.getByte(12);
               ((int[]) buf[14])[0] = rslt.getInt(13);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(9, 10);
               ((String[]) buf[11])[0] = rslt.getVarchar(10);
               ((String[]) buf[12])[0] = rslt.getString(11, 20);
               ((byte[]) buf[13])[0] = rslt.getByte(12);
               ((int[]) buf[14])[0] = rslt.getInt(13);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((String[]) buf[10])[0] = rslt.getString(9, 10);
               ((String[]) buf[11])[0] = rslt.getVarchar(10);
               ((String[]) buf[12])[0] = rslt.getString(11, 20);
               ((byte[]) buf[13])[0] = rslt.getByte(12);
               ((int[]) buf[14])[0] = rslt.getInt(13);
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
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[13]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[14]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 80);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 10);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 400);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[14]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 80);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 10);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 400);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[13]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[14]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 80);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 10);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 400);
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[13]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[14]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 80);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 10);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 400);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[20], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[21], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[23], 400);
               }
               return;
      }
   }

}

