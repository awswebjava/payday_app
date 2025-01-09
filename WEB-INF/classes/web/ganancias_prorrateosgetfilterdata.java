package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ganancias_prorrateosgetfilterdata extends GXProcedure
{
   public ganancias_prorrateosgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ganancias_prorrateosgetfilterdata.class ), "" );
   }

   public ganancias_prorrateosgetfilterdata( int remoteHandle ,
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
      ganancias_prorrateosgetfilterdata.this.aP5 = new String[] {""};
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
      ganancias_prorrateosgetfilterdata.this.AV40DDOName = aP0;
      ganancias_prorrateosgetfilterdata.this.AV41SearchTxt = aP1;
      ganancias_prorrateosgetfilterdata.this.AV42SearchTxtTo = aP2;
      ganancias_prorrateosgetfilterdata.this.aP3 = aP3;
      ganancias_prorrateosgetfilterdata.this.aP4 = aP4;
      ganancias_prorrateosgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV47EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      ganancias_prorrateosgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV47EmpCod = GXt_int1 ;
      GXt_int3 = AV46CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      ganancias_prorrateosgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV46CliCod = GXt_int3 ;
      AV30Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV32OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV33OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "ganancias_prorrateos", GXv_boolean6) ;
      ganancias_prorrateosgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV40DDOName), "DDO_CONCODIGO") == 0 )
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
      }
      AV43OptionsJson = AV30Options.toJSonString(false) ;
      AV44OptionsDescJson = AV32OptionsDesc.toJSonString(false) ;
      AV45OptionIndexesJson = AV33OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV35Session.getValue("ganancias_prorrateosGridState"), "") == 0 )
      {
         AV37GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ganancias_prorrateosGridState"), null, null);
      }
      else
      {
         AV37GridState.fromxml(AV35Session.getValue("ganancias_prorrateosGridState"), null, null);
      }
      AV56GXV1 = 1 ;
      while ( AV56GXV1 <= AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV38GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV37GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV56GXV1));
         if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGCONANIO") == 0 )
         {
            AV11TFLiqLegConAnio = (short)(GXutil.lval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFLiqLegConAnio_To = (short)(GXutil.lval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO") == 0 )
         {
            AV14TFConCodigo = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONCODIGO_SEL") == 0 )
         {
            AV13TFConCodigo_SelsJson = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFConCodigo_Sels.fromJSonString(AV13TFConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQALTANRO") == 0 )
         {
            AV49TFLiqAltaNro = (int)(GXutil.lval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV50TFLiqAltaNro_To = (int)(GXutil.lval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQNUEVANRO") == 0 )
         {
            AV51TFLiqNuevaNro = (int)(GXutil.lval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV52TFLiqNuevaNro_To = (int)(GXutil.lval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGCONSALDO") == 0 )
         {
            AV16TFLiqLegConSaldo = CommonUtil.decimalVal( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV17TFLiqLegConSaldo_To = CommonUtil.decimalVal( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGCONPER") == 0 )
         {
            AV18TFLiqLegConPer = localUtil.ctod( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV19TFLiqLegConPer_To = localUtil.ctod( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGCODIGO") == 0 )
         {
            AV20TFLiqLegCodigo = (short)(GXutil.lval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV21TFLiqLegCodigo_To = (short)(GXutil.lval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGCUOTA") == 0 )
         {
            AV22TFLiqLegCuota = CommonUtil.decimalVal( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV23TFLiqLegCuota_To = CommonUtil.decimalVal( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGTOTAL") == 0 )
         {
            AV24TFLiqLegTotal = CommonUtil.decimalVal( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV25TFLiqLegTotal_To = CommonUtil.decimalVal( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGTOTRECAL") == 0 )
         {
            AV26TFLiqLegTotRecal = CommonUtil.decimalVal( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV27TFLiqLegTotRecal_To = CommonUtil.decimalVal( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV53MenuOpcCod = AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV46CliCod = (int)(GXutil.lval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV47EmpCod = (short)(GXutil.lval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LEGNUMERO") == 0 )
         {
            AV48LegNumero = (int)(GXutil.lval( AV38GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV56GXV1 = (int)(AV56GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCONCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV14TFConCodigo = AV41SearchTxt ;
      AV15TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV58Ganancias_prorrateosds_1_clicod = AV46CliCod ;
      AV59Ganancias_prorrateosds_2_empcod = AV47EmpCod ;
      AV60Ganancias_prorrateosds_3_legnumero = AV48LegNumero ;
      AV61Ganancias_prorrateosds_4_tfliqlegconanio = AV11TFLiqLegConAnio ;
      AV62Ganancias_prorrateosds_5_tfliqlegconanio_to = AV12TFLiqLegConAnio_To ;
      AV63Ganancias_prorrateosds_6_tfconcodigo = AV14TFConCodigo ;
      AV64Ganancias_prorrateosds_7_tfconcodigo_sels = AV15TFConCodigo_Sels ;
      AV65Ganancias_prorrateosds_8_tfliqaltanro = AV49TFLiqAltaNro ;
      AV66Ganancias_prorrateosds_9_tfliqaltanro_to = AV50TFLiqAltaNro_To ;
      AV67Ganancias_prorrateosds_10_tfliqnuevanro = AV51TFLiqNuevaNro ;
      AV68Ganancias_prorrateosds_11_tfliqnuevanro_to = AV52TFLiqNuevaNro_To ;
      AV69Ganancias_prorrateosds_12_tfliqlegconsaldo = AV16TFLiqLegConSaldo ;
      AV70Ganancias_prorrateosds_13_tfliqlegconsaldo_to = AV17TFLiqLegConSaldo_To ;
      AV71Ganancias_prorrateosds_14_tfliqlegconper = AV18TFLiqLegConPer ;
      AV72Ganancias_prorrateosds_15_tfliqlegconper_to = AV19TFLiqLegConPer_To ;
      AV73Ganancias_prorrateosds_16_tfliqlegcodigo = AV20TFLiqLegCodigo ;
      AV74Ganancias_prorrateosds_17_tfliqlegcodigo_to = AV21TFLiqLegCodigo_To ;
      AV75Ganancias_prorrateosds_18_tfliqlegcuota = AV22TFLiqLegCuota ;
      AV76Ganancias_prorrateosds_19_tfliqlegcuota_to = AV23TFLiqLegCuota_To ;
      AV77Ganancias_prorrateosds_20_tfliqlegtotal = AV24TFLiqLegTotal ;
      AV78Ganancias_prorrateosds_21_tfliqlegtotal_to = AV25TFLiqLegTotal_To ;
      AV79Ganancias_prorrateosds_22_tfliqlegtotrecal = AV26TFLiqLegTotRecal ;
      AV80Ganancias_prorrateosds_23_tfliqlegtotrecal_to = AV27TFLiqLegTotRecal_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A26ConCodigo ,
                                           AV64Ganancias_prorrateosds_7_tfconcodigo_sels ,
                                           Short.valueOf(AV61Ganancias_prorrateosds_4_tfliqlegconanio) ,
                                           Short.valueOf(AV62Ganancias_prorrateosds_5_tfliqlegconanio_to) ,
                                           Integer.valueOf(AV64Ganancias_prorrateosds_7_tfconcodigo_sels.size()) ,
                                           AV63Ganancias_prorrateosds_6_tfconcodigo ,
                                           Integer.valueOf(AV65Ganancias_prorrateosds_8_tfliqaltanro) ,
                                           Integer.valueOf(AV66Ganancias_prorrateosds_9_tfliqaltanro_to) ,
                                           Integer.valueOf(AV67Ganancias_prorrateosds_10_tfliqnuevanro) ,
                                           Integer.valueOf(AV68Ganancias_prorrateosds_11_tfliqnuevanro_to) ,
                                           AV69Ganancias_prorrateosds_12_tfliqlegconsaldo ,
                                           AV70Ganancias_prorrateosds_13_tfliqlegconsaldo_to ,
                                           AV71Ganancias_prorrateosds_14_tfliqlegconper ,
                                           AV72Ganancias_prorrateosds_15_tfliqlegconper_to ,
                                           Short.valueOf(AV73Ganancias_prorrateosds_16_tfliqlegcodigo) ,
                                           Short.valueOf(AV74Ganancias_prorrateosds_17_tfliqlegcodigo_to) ,
                                           AV75Ganancias_prorrateosds_18_tfliqlegcuota ,
                                           AV76Ganancias_prorrateosds_19_tfliqlegcuota_to ,
                                           AV77Ganancias_prorrateosds_20_tfliqlegtotal ,
                                           AV78Ganancias_prorrateosds_21_tfliqlegtotal_to ,
                                           AV79Ganancias_prorrateosds_22_tfliqlegtotrecal ,
                                           AV80Ganancias_prorrateosds_23_tfliqlegtotrecal_to ,
                                           Short.valueOf(A869LiqLegConAnio) ,
                                           Integer.valueOf(A1097LiqAltaNro) ,
                                           Integer.valueOf(A1098LiqNuevaNro) ,
                                           A868LiqLegConSaldo ,
                                           A886LiqLegConPer ,
                                           Short.valueOf(A888LiqLegCodigo) ,
                                           A1099LiqLegCuota ,
                                           A1147LiqLegTotal ,
                                           A1148LiqLegTotRecal ,
                                           Integer.valueOf(AV58Ganancias_prorrateosds_1_clicod) ,
                                           Short.valueOf(AV59Ganancias_prorrateosds_2_empcod) ,
                                           Integer.valueOf(AV60Ganancias_prorrateosds_3_legnumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV63Ganancias_prorrateosds_6_tfconcodigo = GXutil.padr( GXutil.rtrim( AV63Ganancias_prorrateosds_6_tfconcodigo), 10, "%") ;
      /* Using cursor P01EN2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV58Ganancias_prorrateosds_1_clicod), Short.valueOf(AV59Ganancias_prorrateosds_2_empcod), Integer.valueOf(AV60Ganancias_prorrateosds_3_legnumero), Short.valueOf(AV61Ganancias_prorrateosds_4_tfliqlegconanio), Short.valueOf(AV62Ganancias_prorrateosds_5_tfliqlegconanio_to), lV63Ganancias_prorrateosds_6_tfconcodigo, Integer.valueOf(AV65Ganancias_prorrateosds_8_tfliqaltanro), Integer.valueOf(AV66Ganancias_prorrateosds_9_tfliqaltanro_to), Integer.valueOf(AV67Ganancias_prorrateosds_10_tfliqnuevanro), Integer.valueOf(AV68Ganancias_prorrateosds_11_tfliqnuevanro_to), AV69Ganancias_prorrateosds_12_tfliqlegconsaldo, AV70Ganancias_prorrateosds_13_tfliqlegconsaldo_to, AV71Ganancias_prorrateosds_14_tfliqlegconper, AV72Ganancias_prorrateosds_15_tfliqlegconper_to, Short.valueOf(AV73Ganancias_prorrateosds_16_tfliqlegcodigo), Short.valueOf(AV74Ganancias_prorrateosds_17_tfliqlegcodigo_to), AV75Ganancias_prorrateosds_18_tfliqlegcuota, AV76Ganancias_prorrateosds_19_tfliqlegcuota_to, AV77Ganancias_prorrateosds_20_tfliqlegtotal, AV78Ganancias_prorrateosds_21_tfliqlegtotal_to, AV79Ganancias_prorrateosds_22_tfliqlegtotrecal, AV80Ganancias_prorrateosds_23_tfliqlegtotrecal_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1EN2 = false ;
         A3CliCod = P01EN2_A3CliCod[0] ;
         A1EmpCod = P01EN2_A1EmpCod[0] ;
         A6LegNumero = P01EN2_A6LegNumero[0] ;
         A26ConCodigo = P01EN2_A26ConCodigo[0] ;
         A1148LiqLegTotRecal = P01EN2_A1148LiqLegTotRecal[0] ;
         A1147LiqLegTotal = P01EN2_A1147LiqLegTotal[0] ;
         A1099LiqLegCuota = P01EN2_A1099LiqLegCuota[0] ;
         A888LiqLegCodigo = P01EN2_A888LiqLegCodigo[0] ;
         n888LiqLegCodigo = P01EN2_n888LiqLegCodigo[0] ;
         A886LiqLegConPer = P01EN2_A886LiqLegConPer[0] ;
         n886LiqLegConPer = P01EN2_n886LiqLegConPer[0] ;
         A868LiqLegConSaldo = P01EN2_A868LiqLegConSaldo[0] ;
         A1098LiqNuevaNro = P01EN2_A1098LiqNuevaNro[0] ;
         A1097LiqAltaNro = P01EN2_A1097LiqAltaNro[0] ;
         A869LiqLegConAnio = P01EN2_A869LiqLegConAnio[0] ;
         AV34count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01EN2_A3CliCod[0] == A3CliCod ) && ( P01EN2_A1EmpCod[0] == A1EmpCod ) && ( P01EN2_A6LegNumero[0] == A6LegNumero ) && ( GXutil.strcmp(P01EN2_A26ConCodigo[0], A26ConCodigo) == 0 ) )
         {
            brk1EN2 = false ;
            A1098LiqNuevaNro = P01EN2_A1098LiqNuevaNro[0] ;
            A1097LiqAltaNro = P01EN2_A1097LiqAltaNro[0] ;
            A869LiqLegConAnio = P01EN2_A869LiqLegConAnio[0] ;
            AV34count = (long)(AV34count+1) ;
            brk1EN2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A26ConCodigo)==0) )
         {
            AV29Option = A26ConCodigo ;
            AV31OptionDesc = GXutil.trim( GXutil.rtrim( localUtil.format( A26ConCodigo, ""))) ;
            AV30Options.add(AV29Option, 0);
            AV32OptionsDesc.add(AV31OptionDesc, 0);
            AV33OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV34count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV30Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1EN2 )
         {
            brk1EN2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = ganancias_prorrateosgetfilterdata.this.AV43OptionsJson;
      this.aP4[0] = ganancias_prorrateosgetfilterdata.this.AV44OptionsDescJson;
      this.aP5[0] = ganancias_prorrateosgetfilterdata.this.AV45OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV43OptionsJson = "" ;
      AV44OptionsDescJson = "" ;
      AV45OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV30Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV32OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV33OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV35Session = httpContext.getWebSession();
      AV37GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV38GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV14TFConCodigo = "" ;
      AV13TFConCodigo_SelsJson = "" ;
      AV15TFConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV16TFLiqLegConSaldo = DecimalUtil.ZERO ;
      AV17TFLiqLegConSaldo_To = DecimalUtil.ZERO ;
      AV18TFLiqLegConPer = GXutil.nullDate() ;
      AV19TFLiqLegConPer_To = GXutil.nullDate() ;
      AV22TFLiqLegCuota = DecimalUtil.ZERO ;
      AV23TFLiqLegCuota_To = DecimalUtil.ZERO ;
      AV24TFLiqLegTotal = DecimalUtil.ZERO ;
      AV25TFLiqLegTotal_To = DecimalUtil.ZERO ;
      AV26TFLiqLegTotRecal = DecimalUtil.ZERO ;
      AV27TFLiqLegTotRecal_To = DecimalUtil.ZERO ;
      AV53MenuOpcCod = "" ;
      A26ConCodigo = "" ;
      AV63Ganancias_prorrateosds_6_tfconcodigo = "" ;
      AV64Ganancias_prorrateosds_7_tfconcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV69Ganancias_prorrateosds_12_tfliqlegconsaldo = DecimalUtil.ZERO ;
      AV70Ganancias_prorrateosds_13_tfliqlegconsaldo_to = DecimalUtil.ZERO ;
      AV71Ganancias_prorrateosds_14_tfliqlegconper = GXutil.nullDate() ;
      AV72Ganancias_prorrateosds_15_tfliqlegconper_to = GXutil.nullDate() ;
      AV75Ganancias_prorrateosds_18_tfliqlegcuota = DecimalUtil.ZERO ;
      AV76Ganancias_prorrateosds_19_tfliqlegcuota_to = DecimalUtil.ZERO ;
      AV77Ganancias_prorrateosds_20_tfliqlegtotal = DecimalUtil.ZERO ;
      AV78Ganancias_prorrateosds_21_tfliqlegtotal_to = DecimalUtil.ZERO ;
      AV79Ganancias_prorrateosds_22_tfliqlegtotrecal = DecimalUtil.ZERO ;
      AV80Ganancias_prorrateosds_23_tfliqlegtotrecal_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV63Ganancias_prorrateosds_6_tfconcodigo = "" ;
      A868LiqLegConSaldo = DecimalUtil.ZERO ;
      A886LiqLegConPer = GXutil.nullDate() ;
      A1099LiqLegCuota = DecimalUtil.ZERO ;
      A1147LiqLegTotal = DecimalUtil.ZERO ;
      A1148LiqLegTotRecal = DecimalUtil.ZERO ;
      P01EN2_A3CliCod = new int[1] ;
      P01EN2_A1EmpCod = new short[1] ;
      P01EN2_A6LegNumero = new int[1] ;
      P01EN2_A26ConCodigo = new String[] {""} ;
      P01EN2_A1148LiqLegTotRecal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01EN2_A1147LiqLegTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01EN2_A1099LiqLegCuota = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01EN2_A888LiqLegCodigo = new short[1] ;
      P01EN2_n888LiqLegCodigo = new boolean[] {false} ;
      P01EN2_A886LiqLegConPer = new java.util.Date[] {GXutil.nullDate()} ;
      P01EN2_n886LiqLegConPer = new boolean[] {false} ;
      P01EN2_A868LiqLegConSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01EN2_A1098LiqNuevaNro = new int[1] ;
      P01EN2_A1097LiqAltaNro = new int[1] ;
      P01EN2_A869LiqLegConAnio = new short[1] ;
      AV29Option = "" ;
      AV31OptionDesc = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ganancias_prorrateosgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01EN2_A3CliCod, P01EN2_A1EmpCod, P01EN2_A6LegNumero, P01EN2_A26ConCodigo, P01EN2_A1148LiqLegTotRecal, P01EN2_A1147LiqLegTotal, P01EN2_A1099LiqLegCuota, P01EN2_A888LiqLegCodigo, P01EN2_n888LiqLegCodigo, P01EN2_A886LiqLegConPer,
            P01EN2_n886LiqLegConPer, P01EN2_A868LiqLegConSaldo, P01EN2_A1098LiqNuevaNro, P01EN2_A1097LiqAltaNro, P01EN2_A869LiqLegConAnio
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV47EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV11TFLiqLegConAnio ;
   private short AV12TFLiqLegConAnio_To ;
   private short AV20TFLiqLegCodigo ;
   private short AV21TFLiqLegCodigo_To ;
   private short AV59Ganancias_prorrateosds_2_empcod ;
   private short AV61Ganancias_prorrateosds_4_tfliqlegconanio ;
   private short AV62Ganancias_prorrateosds_5_tfliqlegconanio_to ;
   private short AV73Ganancias_prorrateosds_16_tfliqlegcodigo ;
   private short AV74Ganancias_prorrateosds_17_tfliqlegcodigo_to ;
   private short A869LiqLegConAnio ;
   private short A888LiqLegCodigo ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV46CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV56GXV1 ;
   private int AV49TFLiqAltaNro ;
   private int AV50TFLiqAltaNro_To ;
   private int AV51TFLiqNuevaNro ;
   private int AV52TFLiqNuevaNro_To ;
   private int AV48LegNumero ;
   private int AV58Ganancias_prorrateosds_1_clicod ;
   private int AV60Ganancias_prorrateosds_3_legnumero ;
   private int AV65Ganancias_prorrateosds_8_tfliqaltanro ;
   private int AV66Ganancias_prorrateosds_9_tfliqaltanro_to ;
   private int AV67Ganancias_prorrateosds_10_tfliqnuevanro ;
   private int AV68Ganancias_prorrateosds_11_tfliqnuevanro_to ;
   private int AV64Ganancias_prorrateosds_7_tfconcodigo_sels_size ;
   private int A1097LiqAltaNro ;
   private int A1098LiqNuevaNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private long AV34count ;
   private java.math.BigDecimal AV16TFLiqLegConSaldo ;
   private java.math.BigDecimal AV17TFLiqLegConSaldo_To ;
   private java.math.BigDecimal AV22TFLiqLegCuota ;
   private java.math.BigDecimal AV23TFLiqLegCuota_To ;
   private java.math.BigDecimal AV24TFLiqLegTotal ;
   private java.math.BigDecimal AV25TFLiqLegTotal_To ;
   private java.math.BigDecimal AV26TFLiqLegTotRecal ;
   private java.math.BigDecimal AV27TFLiqLegTotRecal_To ;
   private java.math.BigDecimal AV69Ganancias_prorrateosds_12_tfliqlegconsaldo ;
   private java.math.BigDecimal AV70Ganancias_prorrateosds_13_tfliqlegconsaldo_to ;
   private java.math.BigDecimal AV75Ganancias_prorrateosds_18_tfliqlegcuota ;
   private java.math.BigDecimal AV76Ganancias_prorrateosds_19_tfliqlegcuota_to ;
   private java.math.BigDecimal AV77Ganancias_prorrateosds_20_tfliqlegtotal ;
   private java.math.BigDecimal AV78Ganancias_prorrateosds_21_tfliqlegtotal_to ;
   private java.math.BigDecimal AV79Ganancias_prorrateosds_22_tfliqlegtotrecal ;
   private java.math.BigDecimal AV80Ganancias_prorrateosds_23_tfliqlegtotrecal_to ;
   private java.math.BigDecimal A868LiqLegConSaldo ;
   private java.math.BigDecimal A1099LiqLegCuota ;
   private java.math.BigDecimal A1147LiqLegTotal ;
   private java.math.BigDecimal A1148LiqLegTotRecal ;
   private String AV14TFConCodigo ;
   private String A26ConCodigo ;
   private String AV63Ganancias_prorrateosds_6_tfconcodigo ;
   private String scmdbuf ;
   private String lV63Ganancias_prorrateosds_6_tfconcodigo ;
   private java.util.Date AV18TFLiqLegConPer ;
   private java.util.Date AV19TFLiqLegConPer_To ;
   private java.util.Date AV71Ganancias_prorrateosds_14_tfliqlegconper ;
   private java.util.Date AV72Ganancias_prorrateosds_15_tfliqlegconper_to ;
   private java.util.Date A886LiqLegConPer ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1EN2 ;
   private boolean n888LiqLegCodigo ;
   private boolean n886LiqLegConPer ;
   private String AV43OptionsJson ;
   private String AV44OptionsDescJson ;
   private String AV45OptionIndexesJson ;
   private String AV13TFConCodigo_SelsJson ;
   private String AV40DDOName ;
   private String AV41SearchTxt ;
   private String AV42SearchTxtTo ;
   private String AV53MenuOpcCod ;
   private String AV29Option ;
   private String AV31OptionDesc ;
   private com.genexus.webpanels.WebSession AV35Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01EN2_A3CliCod ;
   private short[] P01EN2_A1EmpCod ;
   private int[] P01EN2_A6LegNumero ;
   private String[] P01EN2_A26ConCodigo ;
   private java.math.BigDecimal[] P01EN2_A1148LiqLegTotRecal ;
   private java.math.BigDecimal[] P01EN2_A1147LiqLegTotal ;
   private java.math.BigDecimal[] P01EN2_A1099LiqLegCuota ;
   private short[] P01EN2_A888LiqLegCodigo ;
   private boolean[] P01EN2_n888LiqLegCodigo ;
   private java.util.Date[] P01EN2_A886LiqLegConPer ;
   private boolean[] P01EN2_n886LiqLegConPer ;
   private java.math.BigDecimal[] P01EN2_A868LiqLegConSaldo ;
   private int[] P01EN2_A1098LiqNuevaNro ;
   private int[] P01EN2_A1097LiqAltaNro ;
   private short[] P01EN2_A869LiqLegConAnio ;
   private GXSimpleCollection<String> AV15TFConCodigo_Sels ;
   private GXSimpleCollection<String> AV64Ganancias_prorrateosds_7_tfconcodigo_sels ;
   private GXSimpleCollection<String> AV30Options ;
   private GXSimpleCollection<String> AV32OptionsDesc ;
   private GXSimpleCollection<String> AV33OptionIndexes ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV37GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV38GridStateFilterValue ;
}

final  class ganancias_prorrateosgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01EN2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A26ConCodigo ,
                                          GXSimpleCollection<String> AV64Ganancias_prorrateosds_7_tfconcodigo_sels ,
                                          short AV61Ganancias_prorrateosds_4_tfliqlegconanio ,
                                          short AV62Ganancias_prorrateosds_5_tfliqlegconanio_to ,
                                          int AV64Ganancias_prorrateosds_7_tfconcodigo_sels_size ,
                                          String AV63Ganancias_prorrateosds_6_tfconcodigo ,
                                          int AV65Ganancias_prorrateosds_8_tfliqaltanro ,
                                          int AV66Ganancias_prorrateosds_9_tfliqaltanro_to ,
                                          int AV67Ganancias_prorrateosds_10_tfliqnuevanro ,
                                          int AV68Ganancias_prorrateosds_11_tfliqnuevanro_to ,
                                          java.math.BigDecimal AV69Ganancias_prorrateosds_12_tfliqlegconsaldo ,
                                          java.math.BigDecimal AV70Ganancias_prorrateosds_13_tfliqlegconsaldo_to ,
                                          java.util.Date AV71Ganancias_prorrateosds_14_tfliqlegconper ,
                                          java.util.Date AV72Ganancias_prorrateosds_15_tfliqlegconper_to ,
                                          short AV73Ganancias_prorrateosds_16_tfliqlegcodigo ,
                                          short AV74Ganancias_prorrateosds_17_tfliqlegcodigo_to ,
                                          java.math.BigDecimal AV75Ganancias_prorrateosds_18_tfliqlegcuota ,
                                          java.math.BigDecimal AV76Ganancias_prorrateosds_19_tfliqlegcuota_to ,
                                          java.math.BigDecimal AV77Ganancias_prorrateosds_20_tfliqlegtotal ,
                                          java.math.BigDecimal AV78Ganancias_prorrateosds_21_tfliqlegtotal_to ,
                                          java.math.BigDecimal AV79Ganancias_prorrateosds_22_tfliqlegtotrecal ,
                                          java.math.BigDecimal AV80Ganancias_prorrateosds_23_tfliqlegtotrecal_to ,
                                          short A869LiqLegConAnio ,
                                          int A1097LiqAltaNro ,
                                          int A1098LiqNuevaNro ,
                                          java.math.BigDecimal A868LiqLegConSaldo ,
                                          java.util.Date A886LiqLegConPer ,
                                          short A888LiqLegCodigo ,
                                          java.math.BigDecimal A1099LiqLegCuota ,
                                          java.math.BigDecimal A1147LiqLegTotal ,
                                          java.math.BigDecimal A1148LiqLegTotRecal ,
                                          int AV58Ganancias_prorrateosds_1_clicod ,
                                          short AV59Ganancias_prorrateosds_2_empcod ,
                                          int AV60Ganancias_prorrateosds_3_legnumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[22];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, LegNumero, ConCodigo, LiqLegTotRecal, LiqLegTotal, LiqLegCuota, LiqLegCodigo, LiqLegConPer, LiqLegConSaldo, LiqNuevaNro, LiqAltaNro, LiqLegConAnio" ;
      scmdbuf += " FROM LiqLegConceptoCuenta" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ?)");
      if ( ! (0==AV61Ganancias_prorrateosds_4_tfliqlegconanio) )
      {
         addWhere(sWhereString, "(LiqLegConAnio >= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! (0==AV62Ganancias_prorrateosds_5_tfliqlegconanio_to) )
      {
         addWhere(sWhereString, "(LiqLegConAnio <= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ( AV64Ganancias_prorrateosds_7_tfconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV63Ganancias_prorrateosds_6_tfconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( AV64Ganancias_prorrateosds_7_tfconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Ganancias_prorrateosds_7_tfconcodigo_sels, "ConCodigo IN (", ")")+")");
      }
      if ( ! (0==AV65Ganancias_prorrateosds_8_tfliqaltanro) )
      {
         addWhere(sWhereString, "(LiqAltaNro >= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ! (0==AV66Ganancias_prorrateosds_9_tfliqaltanro_to) )
      {
         addWhere(sWhereString, "(LiqAltaNro <= ?)");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( ! (0==AV67Ganancias_prorrateosds_10_tfliqnuevanro) )
      {
         addWhere(sWhereString, "(LiqNuevaNro >= ?)");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( ! (0==AV68Ganancias_prorrateosds_11_tfliqnuevanro_to) )
      {
         addWhere(sWhereString, "(LiqNuevaNro <= ?)");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV69Ganancias_prorrateosds_12_tfliqlegconsaldo)==0) )
      {
         addWhere(sWhereString, "(LiqLegConSaldo >= ?)");
      }
      else
      {
         GXv_int8[10] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV70Ganancias_prorrateosds_13_tfliqlegconsaldo_to)==0) )
      {
         addWhere(sWhereString, "(LiqLegConSaldo <= ?)");
      }
      else
      {
         GXv_int8[11] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV71Ganancias_prorrateosds_14_tfliqlegconper)) )
      {
         addWhere(sWhereString, "(LiqLegConPer >= ?)");
      }
      else
      {
         GXv_int8[12] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV72Ganancias_prorrateosds_15_tfliqlegconper_to)) )
      {
         addWhere(sWhereString, "(LiqLegConPer <= ?)");
      }
      else
      {
         GXv_int8[13] = (byte)(1) ;
      }
      if ( ! (0==AV73Ganancias_prorrateosds_16_tfliqlegcodigo) )
      {
         addWhere(sWhereString, "(LiqLegCodigo >= ?)");
      }
      else
      {
         GXv_int8[14] = (byte)(1) ;
      }
      if ( ! (0==AV74Ganancias_prorrateosds_17_tfliqlegcodigo_to) )
      {
         addWhere(sWhereString, "(LiqLegCodigo <= ?)");
      }
      else
      {
         GXv_int8[15] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV75Ganancias_prorrateosds_18_tfliqlegcuota)==0) )
      {
         addWhere(sWhereString, "(LiqLegCuota >= ?)");
      }
      else
      {
         GXv_int8[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV76Ganancias_prorrateosds_19_tfliqlegcuota_to)==0) )
      {
         addWhere(sWhereString, "(LiqLegCuota <= ?)");
      }
      else
      {
         GXv_int8[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV77Ganancias_prorrateosds_20_tfliqlegtotal)==0) )
      {
         addWhere(sWhereString, "(LiqLegTotal >= ?)");
      }
      else
      {
         GXv_int8[18] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV78Ganancias_prorrateosds_21_tfliqlegtotal_to)==0) )
      {
         addWhere(sWhereString, "(LiqLegTotal <= ?)");
      }
      else
      {
         GXv_int8[19] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV79Ganancias_prorrateosds_22_tfliqlegtotrecal)==0) )
      {
         addWhere(sWhereString, "(LiqLegTotRecal >= ?)");
      }
      else
      {
         GXv_int8[20] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV80Ganancias_prorrateosds_23_tfliqlegtotrecal_to)==0) )
      {
         addWhere(sWhereString, "(LiqLegTotRecal <= ?)");
      }
      else
      {
         GXv_int8[21] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LegNumero, ConCodigo" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
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
                  return conditional_P01EN2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.util.Date)dynConstraints[12] , (java.util.Date)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , (java.math.BigDecimal)dynConstraints[16] , (java.math.BigDecimal)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , (java.math.BigDecimal)dynConstraints[20] , (java.math.BigDecimal)dynConstraints[21] , ((Number) dynConstraints[22]).shortValue() , ((Number) dynConstraints[23]).intValue() , ((Number) dynConstraints[24]).intValue() , (java.math.BigDecimal)dynConstraints[25] , (java.util.Date)dynConstraints[26] , ((Number) dynConstraints[27]).shortValue() , (java.math.BigDecimal)dynConstraints[28] , (java.math.BigDecimal)dynConstraints[29] , (java.math.BigDecimal)dynConstraints[30] , ((Number) dynConstraints[31]).intValue() , ((Number) dynConstraints[32]).shortValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).intValue() , ((Number) dynConstraints[35]).shortValue() , ((Number) dynConstraints[36]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01EN2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(9);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(10,2);
               ((int[]) buf[12])[0] = rslt.getInt(11);
               ((int[]) buf[13])[0] = rslt.getInt(12);
               ((short[]) buf[14])[0] = rslt.getShort(13);
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
                  stmt.setInt(sIdx, ((Number) parms[22]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[23]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[24]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[25]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[26]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[27], 10);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[28]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[29]).intValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[30]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[31]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[32], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[33], 2);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[34]);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[35]);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[36]).shortValue());
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[37]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[38], 2);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[39], 2);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[40], 2);
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[41], 2);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[42], 2);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[43], 2);
               }
               return;
      }
   }

}

