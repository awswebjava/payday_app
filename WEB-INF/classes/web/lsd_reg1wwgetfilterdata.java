package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class lsd_reg1wwgetfilterdata extends GXProcedure
{
   public lsd_reg1wwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( lsd_reg1wwgetfilterdata.class ), "" );
   }

   public lsd_reg1wwgetfilterdata( int remoteHandle ,
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
      lsd_reg1wwgetfilterdata.this.aP5 = new String[] {""};
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
      lsd_reg1wwgetfilterdata.this.AV39DDOName = aP0;
      lsd_reg1wwgetfilterdata.this.AV40SearchTxt = aP1;
      lsd_reg1wwgetfilterdata.this.AV41SearchTxtTo = aP2;
      lsd_reg1wwgetfilterdata.this.aP3 = aP3;
      lsd_reg1wwgetfilterdata.this.aP4 = aP4;
      lsd_reg1wwgetfilterdata.this.aP5 = aP5;
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
      lsd_reg1wwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV46EmpCod = GXt_int1 ;
      GXt_int3 = AV45CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      lsd_reg1wwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV45CliCod = GXt_int3 ;
      AV29Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV31OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV32OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLSD_reg1", GXv_boolean6) ;
      lsd_reg1wwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV39DDOName), "DDO_LSD1IDENTIFICACIONENVIO_14_2") == 0 )
         {
            /* Execute user subroutine: 'LOADLSD1IDENTIFICACIONENVIO_14_2OPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV39DDOName), "DDO_LSD1TIPOLIQUIDACION_22_1") == 0 )
         {
            /* Execute user subroutine: 'LOADLSD1TIPOLIQUIDACION_22_1OPTIONS' */
            S131 ();
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
      if ( GXutil.strcmp(AV34Session.getValue("LSD_reg1WWGridState"), "") == 0 )
      {
         AV36GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LSD_reg1WWGridState"), null, null);
      }
      else
      {
         AV36GridState.fromxml(AV34Session.getValue("LSD_reg1WWGridState"), null, null);
      }
      AV52GXV1 = 1 ;
      while ( AV52GXV1 <= AV36GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV37GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV36GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV52GXV1));
         if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1CUITEMPL_3_11") == 0 )
         {
            AV11TFLSD1CuitEmpl_3_11 = GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()) ;
            AV12TFLSD1CuitEmpl_3_11_To = GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto()) ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1IDENTIFICACIONENVIO_14_2") == 0 )
         {
            AV14TFLSD1IdentificacionEnvio_14_2 = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1IDENTIFICACIONENVIO_14_2_SEL") == 0 )
         {
            AV13TFLSD1IdentificacionEnvio_14_2_SelsJson = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFLSD1IdentificacionEnvio_14_2_Sels.fromJSonString(AV13TFLSD1IdentificacionEnvio_14_2_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1PERIODOLIQUIDACION_16_6") == 0 )
         {
            AV16TFLSD1periodoLiquidacion_16_6 = (int)(GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV17TFLSD1periodoLiquidacion_16_6_To = (int)(GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1TIPOLIQUIDACION_22_1") == 0 )
         {
            AV19TFLSD1tipoLiquidacion_22_1 = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1TIPOLIQUIDACION_22_1_SEL") == 0 )
         {
            AV18TFLSD1tipoLiquidacion_22_1_SelsJson = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV20TFLSD1tipoLiquidacion_22_1_Sels.fromJSonString(AV18TFLSD1tipoLiquidacion_22_1_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1NUMEROLIQUIDACION_23_5") == 0 )
         {
            AV21TFLSD1numeroLiquidacion_23_5 = (int)(GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV22TFLSD1numeroLiquidacion_23_5_To = (int)(GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1DIASBASE_28_2") == 0 )
         {
            AV23TFLSD1diasBase_28_2 = (byte)(GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV24TFLSD1diasBase_28_2_To = (byte)(GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLSD1CANTIDADREGISTROSTIPO04_30_6") == 0 )
         {
            AV25TFLSD1cantidadRegistrosTipo04_30_6 = (int)(GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV26TFLSD1cantidadRegistrosTipo04_30_6_To = (int)(GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV49MenuOpcCod = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV45CliCod = (int)(GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV46EmpCod = (short)(GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&PARMPERIODO") == 0 )
         {
            AV47parmPeriodo = localUtil.ctod( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&PARMNROLIQ") == 0 )
         {
            AV48parmNroLiq = (int)(GXutil.lval( AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV52GXV1 = (int)(AV52GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLSD1IDENTIFICACIONENVIO_14_2OPTIONS' Routine */
      returnInSub = false ;
      AV14TFLSD1IdentificacionEnvio_14_2 = AV40SearchTxt ;
      AV15TFLSD1IdentificacionEnvio_14_2_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV54Lsd_reg1wwds_1_clicod = AV45CliCod ;
      AV55Lsd_reg1wwds_2_empcod = AV46EmpCod ;
      AV56Lsd_reg1wwds_3_tflsd1cuitempl_3_11 = AV11TFLSD1CuitEmpl_3_11 ;
      AV57Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to = AV12TFLSD1CuitEmpl_3_11_To ;
      AV58Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 = AV14TFLSD1IdentificacionEnvio_14_2 ;
      AV59Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels = AV15TFLSD1IdentificacionEnvio_14_2_Sels ;
      AV60Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6 = AV16TFLSD1periodoLiquidacion_16_6 ;
      AV61Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to = AV17TFLSD1periodoLiquidacion_16_6_To ;
      AV62Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 = AV19TFLSD1tipoLiquidacion_22_1 ;
      AV63Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels = AV20TFLSD1tipoLiquidacion_22_1_Sels ;
      AV64Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5 = AV21TFLSD1numeroLiquidacion_23_5 ;
      AV65Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to = AV22TFLSD1numeroLiquidacion_23_5_To ;
      AV66Lsd_reg1wwds_13_tflsd1diasbase_28_2 = AV23TFLSD1diasBase_28_2 ;
      AV67Lsd_reg1wwds_14_tflsd1diasbase_28_2_to = AV24TFLSD1diasBase_28_2_To ;
      AV68Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6 = AV25TFLSD1cantidadRegistrosTipo04_30_6 ;
      AV69Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to = AV26TFLSD1cantidadRegistrosTipo04_30_6_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1651LSD1IdentificacionEnvio_14_2 ,
                                           AV59Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels ,
                                           A1653LSD1tipoLiquidacion_22_1 ,
                                           AV63Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels ,
                                           Long.valueOf(AV56Lsd_reg1wwds_3_tflsd1cuitempl_3_11) ,
                                           Long.valueOf(AV57Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to) ,
                                           Integer.valueOf(AV59Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels.size()) ,
                                           AV58Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 ,
                                           Integer.valueOf(AV60Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6) ,
                                           Integer.valueOf(AV61Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to) ,
                                           Integer.valueOf(AV63Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels.size()) ,
                                           AV62Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 ,
                                           Integer.valueOf(AV64Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5) ,
                                           Integer.valueOf(AV65Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to) ,
                                           Byte.valueOf(AV66Lsd_reg1wwds_13_tflsd1diasbase_28_2) ,
                                           Byte.valueOf(AV67Lsd_reg1wwds_14_tflsd1diasbase_28_2_to) ,
                                           Integer.valueOf(AV68Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6) ,
                                           Integer.valueOf(AV69Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to) ,
                                           Integer.valueOf(AV48parmNroLiq) ,
                                           AV47parmPeriodo ,
                                           Long.valueOf(A1650LSD1CuitEmpl_3_11) ,
                                           Integer.valueOf(A1652LSD1periodoLiquidacion_16_6) ,
                                           Integer.valueOf(A1654LSD1numeroLiquidacion_23_5) ,
                                           Byte.valueOf(A1655LSD1diasBase_28_2) ,
                                           Integer.valueOf(A1656LSD1cantidadRegistrosTipo04_30) ,
                                           Integer.valueOf(A1733LSD1LiqNro) ,
                                           A1734LSD1LiqPeriodo ,
                                           Integer.valueOf(AV54Lsd_reg1wwds_1_clicod) ,
                                           Short.valueOf(AV55Lsd_reg1wwds_2_empcod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.LONG, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV58Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 = GXutil.padr( GXutil.rtrim( AV58Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2), 2, "%") ;
      lV62Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 = GXutil.padr( GXutil.rtrim( AV62Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1), 1, "%") ;
      /* Using cursor P01JM2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV54Lsd_reg1wwds_1_clicod), Short.valueOf(AV55Lsd_reg1wwds_2_empcod), Long.valueOf(AV56Lsd_reg1wwds_3_tflsd1cuitempl_3_11), Long.valueOf(AV57Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to), lV58Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2, Integer.valueOf(AV60Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6), Integer.valueOf(AV61Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to), lV62Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1, Integer.valueOf(AV64Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5), Integer.valueOf(AV65Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to), Byte.valueOf(AV66Lsd_reg1wwds_13_tflsd1diasbase_28_2), Byte.valueOf(AV67Lsd_reg1wwds_14_tflsd1diasbase_28_2_to), Integer.valueOf(AV68Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6), Integer.valueOf(AV69Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to), Integer.valueOf(AV48parmNroLiq), AV47parmPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1JM2 = false ;
         A3CliCod = P01JM2_A3CliCod[0] ;
         A1EmpCod = P01JM2_A1EmpCod[0] ;
         A1651LSD1IdentificacionEnvio_14_2 = P01JM2_A1651LSD1IdentificacionEnvio_14_2[0] ;
         A1734LSD1LiqPeriodo = P01JM2_A1734LSD1LiqPeriodo[0] ;
         A1733LSD1LiqNro = P01JM2_A1733LSD1LiqNro[0] ;
         A1656LSD1cantidadRegistrosTipo04_30 = P01JM2_A1656LSD1cantidadRegistrosTipo04_30[0] ;
         A1655LSD1diasBase_28_2 = P01JM2_A1655LSD1diasBase_28_2[0] ;
         A1654LSD1numeroLiquidacion_23_5 = P01JM2_A1654LSD1numeroLiquidacion_23_5[0] ;
         A1653LSD1tipoLiquidacion_22_1 = P01JM2_A1653LSD1tipoLiquidacion_22_1[0] ;
         A1652LSD1periodoLiquidacion_16_6 = P01JM2_A1652LSD1periodoLiquidacion_16_6[0] ;
         A1650LSD1CuitEmpl_3_11 = P01JM2_A1650LSD1CuitEmpl_3_11[0] ;
         A1649LSDSec = P01JM2_A1649LSDSec[0] ;
         AV33count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01JM2_A3CliCod[0] == A3CliCod ) && ( P01JM2_A1EmpCod[0] == A1EmpCod ) && ( GXutil.strcmp(P01JM2_A1651LSD1IdentificacionEnvio_14_2[0], A1651LSD1IdentificacionEnvio_14_2) == 0 ) )
         {
            brk1JM2 = false ;
            A1649LSDSec = P01JM2_A1649LSDSec[0] ;
            AV33count = (long)(AV33count+1) ;
            brk1JM2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1651LSD1IdentificacionEnvio_14_2)==0) )
         {
            AV28Option = A1651LSD1IdentificacionEnvio_14_2 ;
            AV29Options.add(AV28Option, 0);
            AV32OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV33count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV29Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1JM2 )
         {
            brk1JM2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADLSD1TIPOLIQUIDACION_22_1OPTIONS' Routine */
      returnInSub = false ;
      AV19TFLSD1tipoLiquidacion_22_1 = AV40SearchTxt ;
      AV20TFLSD1tipoLiquidacion_22_1_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV54Lsd_reg1wwds_1_clicod = AV45CliCod ;
      AV55Lsd_reg1wwds_2_empcod = AV46EmpCod ;
      AV56Lsd_reg1wwds_3_tflsd1cuitempl_3_11 = AV11TFLSD1CuitEmpl_3_11 ;
      AV57Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to = AV12TFLSD1CuitEmpl_3_11_To ;
      AV58Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 = AV14TFLSD1IdentificacionEnvio_14_2 ;
      AV59Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels = AV15TFLSD1IdentificacionEnvio_14_2_Sels ;
      AV60Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6 = AV16TFLSD1periodoLiquidacion_16_6 ;
      AV61Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to = AV17TFLSD1periodoLiquidacion_16_6_To ;
      AV62Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 = AV19TFLSD1tipoLiquidacion_22_1 ;
      AV63Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels = AV20TFLSD1tipoLiquidacion_22_1_Sels ;
      AV64Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5 = AV21TFLSD1numeroLiquidacion_23_5 ;
      AV65Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to = AV22TFLSD1numeroLiquidacion_23_5_To ;
      AV66Lsd_reg1wwds_13_tflsd1diasbase_28_2 = AV23TFLSD1diasBase_28_2 ;
      AV67Lsd_reg1wwds_14_tflsd1diasbase_28_2_to = AV24TFLSD1diasBase_28_2_To ;
      AV68Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6 = AV25TFLSD1cantidadRegistrosTipo04_30_6 ;
      AV69Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to = AV26TFLSD1cantidadRegistrosTipo04_30_6_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1651LSD1IdentificacionEnvio_14_2 ,
                                           AV59Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels ,
                                           A1653LSD1tipoLiquidacion_22_1 ,
                                           AV63Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels ,
                                           Long.valueOf(AV56Lsd_reg1wwds_3_tflsd1cuitempl_3_11) ,
                                           Long.valueOf(AV57Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to) ,
                                           Integer.valueOf(AV59Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels.size()) ,
                                           AV58Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 ,
                                           Integer.valueOf(AV60Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6) ,
                                           Integer.valueOf(AV61Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to) ,
                                           Integer.valueOf(AV63Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels.size()) ,
                                           AV62Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 ,
                                           Integer.valueOf(AV64Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5) ,
                                           Integer.valueOf(AV65Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to) ,
                                           Byte.valueOf(AV66Lsd_reg1wwds_13_tflsd1diasbase_28_2) ,
                                           Byte.valueOf(AV67Lsd_reg1wwds_14_tflsd1diasbase_28_2_to) ,
                                           Integer.valueOf(AV68Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6) ,
                                           Integer.valueOf(AV69Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to) ,
                                           Integer.valueOf(AV48parmNroLiq) ,
                                           AV47parmPeriodo ,
                                           Long.valueOf(A1650LSD1CuitEmpl_3_11) ,
                                           Integer.valueOf(A1652LSD1periodoLiquidacion_16_6) ,
                                           Integer.valueOf(A1654LSD1numeroLiquidacion_23_5) ,
                                           Byte.valueOf(A1655LSD1diasBase_28_2) ,
                                           Integer.valueOf(A1656LSD1cantidadRegistrosTipo04_30) ,
                                           Integer.valueOf(A1733LSD1LiqNro) ,
                                           A1734LSD1LiqPeriodo ,
                                           Integer.valueOf(AV54Lsd_reg1wwds_1_clicod) ,
                                           Short.valueOf(AV55Lsd_reg1wwds_2_empcod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.LONG, TypeConstants.LONG, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.LONG, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV58Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 = GXutil.padr( GXutil.rtrim( AV58Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2), 2, "%") ;
      lV62Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 = GXutil.padr( GXutil.rtrim( AV62Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1), 1, "%") ;
      /* Using cursor P01JM3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV54Lsd_reg1wwds_1_clicod), Short.valueOf(AV55Lsd_reg1wwds_2_empcod), Long.valueOf(AV56Lsd_reg1wwds_3_tflsd1cuitempl_3_11), Long.valueOf(AV57Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to), lV58Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2, Integer.valueOf(AV60Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6), Integer.valueOf(AV61Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to), lV62Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1, Integer.valueOf(AV64Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5), Integer.valueOf(AV65Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to), Byte.valueOf(AV66Lsd_reg1wwds_13_tflsd1diasbase_28_2), Byte.valueOf(AV67Lsd_reg1wwds_14_tflsd1diasbase_28_2_to), Integer.valueOf(AV68Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6), Integer.valueOf(AV69Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to), Integer.valueOf(AV48parmNroLiq), AV47parmPeriodo});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1JM4 = false ;
         A3CliCod = P01JM3_A3CliCod[0] ;
         A1EmpCod = P01JM3_A1EmpCod[0] ;
         A1653LSD1tipoLiquidacion_22_1 = P01JM3_A1653LSD1tipoLiquidacion_22_1[0] ;
         A1734LSD1LiqPeriodo = P01JM3_A1734LSD1LiqPeriodo[0] ;
         A1733LSD1LiqNro = P01JM3_A1733LSD1LiqNro[0] ;
         A1656LSD1cantidadRegistrosTipo04_30 = P01JM3_A1656LSD1cantidadRegistrosTipo04_30[0] ;
         A1655LSD1diasBase_28_2 = P01JM3_A1655LSD1diasBase_28_2[0] ;
         A1654LSD1numeroLiquidacion_23_5 = P01JM3_A1654LSD1numeroLiquidacion_23_5[0] ;
         A1652LSD1periodoLiquidacion_16_6 = P01JM3_A1652LSD1periodoLiquidacion_16_6[0] ;
         A1651LSD1IdentificacionEnvio_14_2 = P01JM3_A1651LSD1IdentificacionEnvio_14_2[0] ;
         A1650LSD1CuitEmpl_3_11 = P01JM3_A1650LSD1CuitEmpl_3_11[0] ;
         A1649LSDSec = P01JM3_A1649LSDSec[0] ;
         AV33count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P01JM3_A3CliCod[0] == A3CliCod ) && ( P01JM3_A1EmpCod[0] == A1EmpCod ) && ( GXutil.strcmp(P01JM3_A1653LSD1tipoLiquidacion_22_1[0], A1653LSD1tipoLiquidacion_22_1) == 0 ) )
         {
            brk1JM4 = false ;
            A1649LSDSec = P01JM3_A1649LSDSec[0] ;
            AV33count = (long)(AV33count+1) ;
            brk1JM4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1653LSD1tipoLiquidacion_22_1)==0) )
         {
            AV28Option = A1653LSD1tipoLiquidacion_22_1 ;
            AV29Options.add(AV28Option, 0);
            AV32OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV33count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV29Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1JM4 )
         {
            brk1JM4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = lsd_reg1wwgetfilterdata.this.AV42OptionsJson;
      this.aP4[0] = lsd_reg1wwgetfilterdata.this.AV43OptionsDescJson;
      this.aP5[0] = lsd_reg1wwgetfilterdata.this.AV44OptionIndexesJson;
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
      AV14TFLSD1IdentificacionEnvio_14_2 = "" ;
      AV13TFLSD1IdentificacionEnvio_14_2_SelsJson = "" ;
      AV15TFLSD1IdentificacionEnvio_14_2_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19TFLSD1tipoLiquidacion_22_1 = "" ;
      AV18TFLSD1tipoLiquidacion_22_1_SelsJson = "" ;
      AV20TFLSD1tipoLiquidacion_22_1_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49MenuOpcCod = "" ;
      AV47parmPeriodo = GXutil.nullDate() ;
      A1651LSD1IdentificacionEnvio_14_2 = "" ;
      AV58Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 = "" ;
      AV59Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV62Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 = "" ;
      AV63Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV58Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 = "" ;
      lV62Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 = "" ;
      A1653LSD1tipoLiquidacion_22_1 = "" ;
      A1734LSD1LiqPeriodo = GXutil.nullDate() ;
      P01JM2_A3CliCod = new int[1] ;
      P01JM2_A1EmpCod = new short[1] ;
      P01JM2_A1651LSD1IdentificacionEnvio_14_2 = new String[] {""} ;
      P01JM2_A1734LSD1LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01JM2_A1733LSD1LiqNro = new int[1] ;
      P01JM2_A1656LSD1cantidadRegistrosTipo04_30 = new int[1] ;
      P01JM2_A1655LSD1diasBase_28_2 = new byte[1] ;
      P01JM2_A1654LSD1numeroLiquidacion_23_5 = new int[1] ;
      P01JM2_A1653LSD1tipoLiquidacion_22_1 = new String[] {""} ;
      P01JM2_A1652LSD1periodoLiquidacion_16_6 = new int[1] ;
      P01JM2_A1650LSD1CuitEmpl_3_11 = new long[1] ;
      P01JM2_A1649LSDSec = new int[1] ;
      AV28Option = "" ;
      P01JM3_A3CliCod = new int[1] ;
      P01JM3_A1EmpCod = new short[1] ;
      P01JM3_A1653LSD1tipoLiquidacion_22_1 = new String[] {""} ;
      P01JM3_A1734LSD1LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01JM3_A1733LSD1LiqNro = new int[1] ;
      P01JM3_A1656LSD1cantidadRegistrosTipo04_30 = new int[1] ;
      P01JM3_A1655LSD1diasBase_28_2 = new byte[1] ;
      P01JM3_A1654LSD1numeroLiquidacion_23_5 = new int[1] ;
      P01JM3_A1652LSD1periodoLiquidacion_16_6 = new int[1] ;
      P01JM3_A1651LSD1IdentificacionEnvio_14_2 = new String[] {""} ;
      P01JM3_A1650LSD1CuitEmpl_3_11 = new long[1] ;
      P01JM3_A1649LSDSec = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.lsd_reg1wwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01JM2_A3CliCod, P01JM2_A1EmpCod, P01JM2_A1651LSD1IdentificacionEnvio_14_2, P01JM2_A1734LSD1LiqPeriodo, P01JM2_A1733LSD1LiqNro, P01JM2_A1656LSD1cantidadRegistrosTipo04_30, P01JM2_A1655LSD1diasBase_28_2, P01JM2_A1654LSD1numeroLiquidacion_23_5, P01JM2_A1653LSD1tipoLiquidacion_22_1, P01JM2_A1652LSD1periodoLiquidacion_16_6,
            P01JM2_A1650LSD1CuitEmpl_3_11, P01JM2_A1649LSDSec
            }
            , new Object[] {
            P01JM3_A3CliCod, P01JM3_A1EmpCod, P01JM3_A1653LSD1tipoLiquidacion_22_1, P01JM3_A1734LSD1LiqPeriodo, P01JM3_A1733LSD1LiqNro, P01JM3_A1656LSD1cantidadRegistrosTipo04_30, P01JM3_A1655LSD1diasBase_28_2, P01JM3_A1654LSD1numeroLiquidacion_23_5, P01JM3_A1652LSD1periodoLiquidacion_16_6, P01JM3_A1651LSD1IdentificacionEnvio_14_2,
            P01JM3_A1650LSD1CuitEmpl_3_11, P01JM3_A1649LSDSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV23TFLSD1diasBase_28_2 ;
   private byte AV24TFLSD1diasBase_28_2_To ;
   private byte AV66Lsd_reg1wwds_13_tflsd1diasbase_28_2 ;
   private byte AV67Lsd_reg1wwds_14_tflsd1diasbase_28_2_to ;
   private byte A1655LSD1diasBase_28_2 ;
   private short AV46EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV55Lsd_reg1wwds_2_empcod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV45CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV52GXV1 ;
   private int AV16TFLSD1periodoLiquidacion_16_6 ;
   private int AV17TFLSD1periodoLiquidacion_16_6_To ;
   private int AV21TFLSD1numeroLiquidacion_23_5 ;
   private int AV22TFLSD1numeroLiquidacion_23_5_To ;
   private int AV25TFLSD1cantidadRegistrosTipo04_30_6 ;
   private int AV26TFLSD1cantidadRegistrosTipo04_30_6_To ;
   private int AV48parmNroLiq ;
   private int AV54Lsd_reg1wwds_1_clicod ;
   private int AV60Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6 ;
   private int AV61Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to ;
   private int AV64Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5 ;
   private int AV65Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to ;
   private int AV68Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6 ;
   private int AV69Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to ;
   private int AV59Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels_size ;
   private int AV63Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels_size ;
   private int A1652LSD1periodoLiquidacion_16_6 ;
   private int A1654LSD1numeroLiquidacion_23_5 ;
   private int A1656LSD1cantidadRegistrosTipo04_30 ;
   private int A1733LSD1LiqNro ;
   private int A3CliCod ;
   private int A1649LSDSec ;
   private long AV11TFLSD1CuitEmpl_3_11 ;
   private long AV12TFLSD1CuitEmpl_3_11_To ;
   private long AV56Lsd_reg1wwds_3_tflsd1cuitempl_3_11 ;
   private long AV57Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to ;
   private long A1650LSD1CuitEmpl_3_11 ;
   private long AV33count ;
   private String AV14TFLSD1IdentificacionEnvio_14_2 ;
   private String AV19TFLSD1tipoLiquidacion_22_1 ;
   private String A1651LSD1IdentificacionEnvio_14_2 ;
   private String AV58Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 ;
   private String AV62Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 ;
   private String scmdbuf ;
   private String lV58Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 ;
   private String lV62Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 ;
   private String A1653LSD1tipoLiquidacion_22_1 ;
   private java.util.Date AV47parmPeriodo ;
   private java.util.Date A1734LSD1LiqPeriodo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1JM2 ;
   private boolean brk1JM4 ;
   private String AV42OptionsJson ;
   private String AV43OptionsDescJson ;
   private String AV44OptionIndexesJson ;
   private String AV13TFLSD1IdentificacionEnvio_14_2_SelsJson ;
   private String AV18TFLSD1tipoLiquidacion_22_1_SelsJson ;
   private String AV39DDOName ;
   private String AV40SearchTxt ;
   private String AV41SearchTxtTo ;
   private String AV49MenuOpcCod ;
   private String AV28Option ;
   private com.genexus.webpanels.WebSession AV34Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01JM2_A3CliCod ;
   private short[] P01JM2_A1EmpCod ;
   private String[] P01JM2_A1651LSD1IdentificacionEnvio_14_2 ;
   private java.util.Date[] P01JM2_A1734LSD1LiqPeriodo ;
   private int[] P01JM2_A1733LSD1LiqNro ;
   private int[] P01JM2_A1656LSD1cantidadRegistrosTipo04_30 ;
   private byte[] P01JM2_A1655LSD1diasBase_28_2 ;
   private int[] P01JM2_A1654LSD1numeroLiquidacion_23_5 ;
   private String[] P01JM2_A1653LSD1tipoLiquidacion_22_1 ;
   private int[] P01JM2_A1652LSD1periodoLiquidacion_16_6 ;
   private long[] P01JM2_A1650LSD1CuitEmpl_3_11 ;
   private int[] P01JM2_A1649LSDSec ;
   private int[] P01JM3_A3CliCod ;
   private short[] P01JM3_A1EmpCod ;
   private String[] P01JM3_A1653LSD1tipoLiquidacion_22_1 ;
   private java.util.Date[] P01JM3_A1734LSD1LiqPeriodo ;
   private int[] P01JM3_A1733LSD1LiqNro ;
   private int[] P01JM3_A1656LSD1cantidadRegistrosTipo04_30 ;
   private byte[] P01JM3_A1655LSD1diasBase_28_2 ;
   private int[] P01JM3_A1654LSD1numeroLiquidacion_23_5 ;
   private int[] P01JM3_A1652LSD1periodoLiquidacion_16_6 ;
   private String[] P01JM3_A1651LSD1IdentificacionEnvio_14_2 ;
   private long[] P01JM3_A1650LSD1CuitEmpl_3_11 ;
   private int[] P01JM3_A1649LSDSec ;
   private GXSimpleCollection<String> AV15TFLSD1IdentificacionEnvio_14_2_Sels ;
   private GXSimpleCollection<String> AV20TFLSD1tipoLiquidacion_22_1_Sels ;
   private GXSimpleCollection<String> AV59Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels ;
   private GXSimpleCollection<String> AV63Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels ;
   private GXSimpleCollection<String> AV29Options ;
   private GXSimpleCollection<String> AV31OptionsDesc ;
   private GXSimpleCollection<String> AV32OptionIndexes ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV36GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV37GridStateFilterValue ;
}

final  class lsd_reg1wwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01JM2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1651LSD1IdentificacionEnvio_14_2 ,
                                          GXSimpleCollection<String> AV59Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels ,
                                          String A1653LSD1tipoLiquidacion_22_1 ,
                                          GXSimpleCollection<String> AV63Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels ,
                                          long AV56Lsd_reg1wwds_3_tflsd1cuitempl_3_11 ,
                                          long AV57Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to ,
                                          int AV59Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels_size ,
                                          String AV58Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 ,
                                          int AV60Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6 ,
                                          int AV61Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to ,
                                          int AV63Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels_size ,
                                          String AV62Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 ,
                                          int AV64Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5 ,
                                          int AV65Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to ,
                                          byte AV66Lsd_reg1wwds_13_tflsd1diasbase_28_2 ,
                                          byte AV67Lsd_reg1wwds_14_tflsd1diasbase_28_2_to ,
                                          int AV68Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6 ,
                                          int AV69Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to ,
                                          int AV48parmNroLiq ,
                                          java.util.Date AV47parmPeriodo ,
                                          long A1650LSD1CuitEmpl_3_11 ,
                                          int A1652LSD1periodoLiquidacion_16_6 ,
                                          int A1654LSD1numeroLiquidacion_23_5 ,
                                          byte A1655LSD1diasBase_28_2 ,
                                          int A1656LSD1cantidadRegistrosTipo04_30 ,
                                          int A1733LSD1LiqNro ,
                                          java.util.Date A1734LSD1LiqPeriodo ,
                                          int AV54Lsd_reg1wwds_1_clicod ,
                                          short AV55Lsd_reg1wwds_2_empcod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[16];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, LSD1IdentificacionEnvio_14_2, LSD1LiqPeriodo, LSD1LiqNro, LSD1cantidadRegistrosTipo04_30, LSD1diasBase_28_2, LSD1numeroLiquidacion_23_5, LSD1tipoLiquidacion_22_1," ;
      scmdbuf += " LSD1periodoLiquidacion_16_6, LSD1CuitEmpl_3_11, LSDSec FROM LSD_reg1" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV56Lsd_reg1wwds_3_tflsd1cuitempl_3_11) )
      {
         addWhere(sWhereString, "(LSD1CuitEmpl_3_11 >= ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ! (0==AV57Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to) )
      {
         addWhere(sWhereString, "(LSD1CuitEmpl_3_11 <= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ( AV59Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV58Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LSD1IdentificacionEnvio_14_2) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV59Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels, "LSD1IdentificacionEnvio_14_2 IN (", ")")+")");
      }
      if ( ! (0==AV60Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6) )
      {
         addWhere(sWhereString, "(LSD1periodoLiquidacion_16_6 >= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! (0==AV61Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to) )
      {
         addWhere(sWhereString, "(LSD1periodoLiquidacion_16_6 <= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ( AV63Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LSD1tipoLiquidacion_22_1) like LOWER(?))");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( AV63Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels, "LSD1tipoLiquidacion_22_1 IN (", ")")+")");
      }
      if ( ! (0==AV64Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5) )
      {
         addWhere(sWhereString, "(LSD1numeroLiquidacion_23_5 >= ?)");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( ! (0==AV65Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to) )
      {
         addWhere(sWhereString, "(LSD1numeroLiquidacion_23_5 <= ?)");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      if ( ! (0==AV66Lsd_reg1wwds_13_tflsd1diasbase_28_2) )
      {
         addWhere(sWhereString, "(LSD1diasBase_28_2 >= ?)");
      }
      else
      {
         GXv_int8[10] = (byte)(1) ;
      }
      if ( ! (0==AV67Lsd_reg1wwds_14_tflsd1diasbase_28_2_to) )
      {
         addWhere(sWhereString, "(LSD1diasBase_28_2 <= ?)");
      }
      else
      {
         GXv_int8[11] = (byte)(1) ;
      }
      if ( ! (0==AV68Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6) )
      {
         addWhere(sWhereString, "(LSD1cantidadRegistrosTipo04_30 >= ?)");
      }
      else
      {
         GXv_int8[12] = (byte)(1) ;
      }
      if ( ! (0==AV69Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to) )
      {
         addWhere(sWhereString, "(LSD1cantidadRegistrosTipo04_30 <= ?)");
      }
      else
      {
         GXv_int8[13] = (byte)(1) ;
      }
      if ( ! (0==AV48parmNroLiq) )
      {
         addWhere(sWhereString, "(LSD1LiqNro = ?)");
      }
      else
      {
         GXv_int8[14] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV47parmPeriodo)) )
      {
         addWhere(sWhereString, "(LSD1LiqPeriodo = ?)");
      }
      else
      {
         GXv_int8[15] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LSD1IdentificacionEnvio_14_2" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01JM3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1651LSD1IdentificacionEnvio_14_2 ,
                                          GXSimpleCollection<String> AV59Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels ,
                                          String A1653LSD1tipoLiquidacion_22_1 ,
                                          GXSimpleCollection<String> AV63Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels ,
                                          long AV56Lsd_reg1wwds_3_tflsd1cuitempl_3_11 ,
                                          long AV57Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to ,
                                          int AV59Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels_size ,
                                          String AV58Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2 ,
                                          int AV60Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6 ,
                                          int AV61Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to ,
                                          int AV63Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels_size ,
                                          String AV62Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1 ,
                                          int AV64Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5 ,
                                          int AV65Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to ,
                                          byte AV66Lsd_reg1wwds_13_tflsd1diasbase_28_2 ,
                                          byte AV67Lsd_reg1wwds_14_tflsd1diasbase_28_2_to ,
                                          int AV68Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6 ,
                                          int AV69Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to ,
                                          int AV48parmNroLiq ,
                                          java.util.Date AV47parmPeriodo ,
                                          long A1650LSD1CuitEmpl_3_11 ,
                                          int A1652LSD1periodoLiquidacion_16_6 ,
                                          int A1654LSD1numeroLiquidacion_23_5 ,
                                          byte A1655LSD1diasBase_28_2 ,
                                          int A1656LSD1cantidadRegistrosTipo04_30 ,
                                          int A1733LSD1LiqNro ,
                                          java.util.Date A1734LSD1LiqPeriodo ,
                                          int AV54Lsd_reg1wwds_1_clicod ,
                                          short AV55Lsd_reg1wwds_2_empcod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[16];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, LSD1tipoLiquidacion_22_1, LSD1LiqPeriodo, LSD1LiqNro, LSD1cantidadRegistrosTipo04_30, LSD1diasBase_28_2, LSD1numeroLiquidacion_23_5, LSD1periodoLiquidacion_16_6," ;
      scmdbuf += " LSD1IdentificacionEnvio_14_2, LSD1CuitEmpl_3_11, LSDSec FROM LSD_reg1" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV56Lsd_reg1wwds_3_tflsd1cuitempl_3_11) )
      {
         addWhere(sWhereString, "(LSD1CuitEmpl_3_11 >= ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( ! (0==AV57Lsd_reg1wwds_4_tflsd1cuitempl_3_11_to) )
      {
         addWhere(sWhereString, "(LSD1CuitEmpl_3_11 <= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ( AV59Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV58Lsd_reg1wwds_5_tflsd1identificacionenvio_14_2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LSD1IdentificacionEnvio_14_2) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV59Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Lsd_reg1wwds_6_tflsd1identificacionenvio_14_2_sels, "LSD1IdentificacionEnvio_14_2 IN (", ")")+")");
      }
      if ( ! (0==AV60Lsd_reg1wwds_7_tflsd1periodoliquidacion_16_6) )
      {
         addWhere(sWhereString, "(LSD1periodoLiquidacion_16_6 >= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! (0==AV61Lsd_reg1wwds_8_tflsd1periodoliquidacion_16_6_to) )
      {
         addWhere(sWhereString, "(LSD1periodoLiquidacion_16_6 <= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ( AV63Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Lsd_reg1wwds_9_tflsd1tipoliquidacion_22_1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LSD1tipoLiquidacion_22_1) like LOWER(?))");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( AV63Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Lsd_reg1wwds_10_tflsd1tipoliquidacion_22_1_sels, "LSD1tipoLiquidacion_22_1 IN (", ")")+")");
      }
      if ( ! (0==AV64Lsd_reg1wwds_11_tflsd1numeroliquidacion_23_5) )
      {
         addWhere(sWhereString, "(LSD1numeroLiquidacion_23_5 >= ?)");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( ! (0==AV65Lsd_reg1wwds_12_tflsd1numeroliquidacion_23_5_to) )
      {
         addWhere(sWhereString, "(LSD1numeroLiquidacion_23_5 <= ?)");
      }
      else
      {
         GXv_int11[9] = (byte)(1) ;
      }
      if ( ! (0==AV66Lsd_reg1wwds_13_tflsd1diasbase_28_2) )
      {
         addWhere(sWhereString, "(LSD1diasBase_28_2 >= ?)");
      }
      else
      {
         GXv_int11[10] = (byte)(1) ;
      }
      if ( ! (0==AV67Lsd_reg1wwds_14_tflsd1diasbase_28_2_to) )
      {
         addWhere(sWhereString, "(LSD1diasBase_28_2 <= ?)");
      }
      else
      {
         GXv_int11[11] = (byte)(1) ;
      }
      if ( ! (0==AV68Lsd_reg1wwds_15_tflsd1cantidadregistrostipo04_30_6) )
      {
         addWhere(sWhereString, "(LSD1cantidadRegistrosTipo04_30 >= ?)");
      }
      else
      {
         GXv_int11[12] = (byte)(1) ;
      }
      if ( ! (0==AV69Lsd_reg1wwds_16_tflsd1cantidadregistrostipo04_30_6_to) )
      {
         addWhere(sWhereString, "(LSD1cantidadRegistrosTipo04_30 <= ?)");
      }
      else
      {
         GXv_int11[13] = (byte)(1) ;
      }
      if ( ! (0==AV48parmNroLiq) )
      {
         addWhere(sWhereString, "(LSD1LiqNro = ?)");
      }
      else
      {
         GXv_int11[14] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV47parmPeriodo)) )
      {
         addWhere(sWhereString, "(LSD1LiqPeriodo = ?)");
      }
      else
      {
         GXv_int11[15] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LSD1tipoLiquidacion_22_1" ;
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
                  return conditional_P01JM2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).longValue() , ((Number) dynConstraints[5]).longValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).intValue() , (java.util.Date)dynConstraints[19] , ((Number) dynConstraints[20]).longValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).byteValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , (java.util.Date)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).shortValue() , ((Number) dynConstraints[29]).intValue() , ((Number) dynConstraints[30]).shortValue() );
            case 1 :
                  return conditional_P01JM3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).longValue() , ((Number) dynConstraints[5]).longValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).intValue() , (java.util.Date)dynConstraints[19] , ((Number) dynConstraints[20]).longValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).byteValue() , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).intValue() , (java.util.Date)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).shortValue() , ((Number) dynConstraints[29]).intValue() , ((Number) dynConstraints[30]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01JM2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01JM3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 2);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((long[]) buf[10])[0] = rslt.getLong(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 2);
               ((long[]) buf[10])[0] = rslt.getLong(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
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
                  stmt.setInt(sIdx, ((Number) parms[16]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[18]).longValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[19]).longValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 2);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[22]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[23], 1);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[25]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[26]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[27]).byteValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[28]).intValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[29]).intValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[30]).intValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[31]);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[16]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[17]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[18]).longValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[19]).longValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 2);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[22]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[23], 1);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[25]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[26]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[27]).byteValue());
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[28]).intValue());
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[29]).intValue());
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[30]).intValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[31]);
               }
               return;
      }
   }

}

