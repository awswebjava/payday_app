package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liquidacionlegajowcgetfilterdata extends GXProcedure
{
   public liquidacionlegajowcgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacionlegajowcgetfilterdata.class ), "" );
   }

   public liquidacionlegajowcgetfilterdata( int remoteHandle ,
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
      liquidacionlegajowcgetfilterdata.this.aP5 = new String[] {""};
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
      liquidacionlegajowcgetfilterdata.this.AV15DDOName = aP0;
      liquidacionlegajowcgetfilterdata.this.AV13SearchTxt = aP1;
      liquidacionlegajowcgetfilterdata.this.AV14SearchTxtTo = aP2;
      liquidacionlegajowcgetfilterdata.this.aP3 = aP3;
      liquidacionlegajowcgetfilterdata.this.aP4 = aP4;
      liquidacionlegajowcgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV18Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV21OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV23OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiquidacion", GXv_boolean2) ;
      liquidacionlegajowcgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV15DDOName), "DDO_LIQLEGERROR") == 0 )
         {
            /* Execute user subroutine: 'LOADLIQLEGERROROPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV15DDOName), "DDO_LIQLEGERRORAUX") == 0 )
         {
            /* Execute user subroutine: 'LOADLIQLEGERRORAUXOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV19OptionsJson = AV18Options.toJSonString(false) ;
      AV22OptionsDescJson = AV21OptionsDesc.toJSonString(false) ;
      AV24OptionIndexesJson = AV23OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV26Session.getValue("LiquidacionLegajoWCGridState"), "") == 0 )
      {
         AV28GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LiquidacionLegajoWCGridState"), null, null);
      }
      else
      {
         AV28GridState.fromxml(AV26Session.getValue("LiquidacionLegajoWCGridState"), null, null);
      }
      AV122GXV1 = 1 ;
      while ( AV122GXV1 <= AV28GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV29GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV28GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV122GXV1));
         if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPBASICO") == 0 )
         {
            AV93TFLiqLegImpBasico = CommonUtil.decimalVal( AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV94TFLiqLegImpBasico_To = CommonUtil.decimalVal( AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTBRUTO") == 0 )
         {
            AV82TFLiqLegImpTotBruto = CommonUtil.decimalVal( AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV83TFLiqLegImpTotBruto_To = CommonUtil.decimalVal( AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTBRUSINSAC") == 0 )
         {
            AV91TFLiqLegImpTotBruSinSAC = CommonUtil.decimalVal( AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV92TFLiqLegImpTotBruSinSAC_To = CommonUtil.decimalVal( AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPTOTRETGAN") == 0 )
         {
            AV87TFLiqLegImpTotRetGan = CommonUtil.decimalVal( AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV88TFLiqLegImpTotRetGan_To = CommonUtil.decimalVal( AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGERROR") == 0 )
         {
            AV110TFLiqLegError = AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGERROR_SEL") == 0 )
         {
            AV109TFLiqLegError_SelsJson = AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV111TFLiqLegError_Sels.fromJSonString(AV109TFLiqLegError_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGERRORAUX") == 0 )
         {
            AV114TFLiqLegErrorAux = AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGERRORAUX_SEL") == 0 )
         {
            AV113TFLiqLegErrorAux_SelsJson = AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV115TFLiqLegErrorAux_Sels.fromJSonString(AV113TFLiqLegErrorAux_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGIMPCONTR") == 0 )
         {
            AV101TFLiqLegImpContr = CommonUtil.decimalVal( AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV102TFLiqLegImpContr_To = CommonUtil.decimalVal( AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGITERACIONES") == 0 )
         {
            AV105TFLIqLegIteraciones = (short)(GXutil.lval( AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV106TFLIqLegIteraciones_To = (short)(GXutil.lval( AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGSEGUNDOS") == 0 )
         {
            AV107TFLiqLegSegundos = CommonUtil.decimalVal( AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV108TFLiqLegSegundos_To = CommonUtil.decimalVal( AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQLEGAUXESTADO_SEL") == 0 )
         {
            AV116TFLiqLegAuxEstado_SelsJson = AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV117TFLiqLegAuxEstado_Sels.fromJSonString(AV116TFLiqLegAuxEstado_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV112MenuOpcCod = AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV80CliCod = (int)(GXutil.lval( AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV31EmpCod = (short)(GXutil.lval( AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LIQNRO") == 0 )
         {
            AV32LiqNro = (int)(GXutil.lval( AV29GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV122GXV1 = (int)(AV122GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLIQLEGERROROPTIONS' Routine */
      returnInSub = false ;
      AV110TFLiqLegError = AV13SearchTxt ;
      AV111TFLiqLegError_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A891LiqLegError ,
                                           AV111TFLiqLegError_Sels ,
                                           A1781LiqLegErrorAux ,
                                           AV115TFLiqLegErrorAux_Sels ,
                                           Byte.valueOf(A1780LiqLegAuxEstado) ,
                                           AV117TFLiqLegAuxEstado_Sels ,
                                           AV93TFLiqLegImpBasico ,
                                           AV94TFLiqLegImpBasico_To ,
                                           AV82TFLiqLegImpTotBruto ,
                                           AV83TFLiqLegImpTotBruto_To ,
                                           AV91TFLiqLegImpTotBruSinSAC ,
                                           AV92TFLiqLegImpTotBruSinSAC_To ,
                                           AV87TFLiqLegImpTotRetGan ,
                                           AV88TFLiqLegImpTotRetGan_To ,
                                           Integer.valueOf(AV111TFLiqLegError_Sels.size()) ,
                                           AV110TFLiqLegError ,
                                           Integer.valueOf(AV115TFLiqLegErrorAux_Sels.size()) ,
                                           AV114TFLiqLegErrorAux ,
                                           AV101TFLiqLegImpContr ,
                                           AV102TFLiqLegImpContr_To ,
                                           Short.valueOf(AV105TFLIqLegIteraciones) ,
                                           Short.valueOf(AV106TFLIqLegIteraciones_To) ,
                                           AV107TFLiqLegSegundos ,
                                           AV108TFLiqLegSegundos_To ,
                                           Integer.valueOf(AV117TFLiqLegAuxEstado_Sels.size()) ,
                                           A760LiqLegImpBasico ,
                                           A498LiqLegImpTotBruto ,
                                           A759LiqLegImpTotBruSinSAC ,
                                           A757LiqLegImpTotRetGan ,
                                           A1157LiqLegImpContr ,
                                           Short.valueOf(A883LIqLegIteraciones) ,
                                           A884LiqLegSegundos ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV80CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV31EmpCod) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(AV32LiqNro) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV110TFLiqLegError = GXutil.concat( GXutil.rtrim( AV110TFLiqLegError), "%", "") ;
      lV114TFLiqLegErrorAux = GXutil.concat( GXutil.rtrim( AV114TFLiqLegErrorAux), "%", "") ;
      /* Using cursor P00AM2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV80CliCod), Short.valueOf(AV31EmpCod), Integer.valueOf(AV32LiqNro), AV93TFLiqLegImpBasico, AV94TFLiqLegImpBasico_To, AV82TFLiqLegImpTotBruto, AV83TFLiqLegImpTotBruto_To, AV91TFLiqLegImpTotBruSinSAC, AV92TFLiqLegImpTotBruSinSAC_To, AV87TFLiqLegImpTotRetGan, AV88TFLiqLegImpTotRetGan_To, lV110TFLiqLegError, lV114TFLiqLegErrorAux, AV101TFLiqLegImpContr, AV102TFLiqLegImpContr_To, Short.valueOf(AV105TFLIqLegIteraciones), Short.valueOf(AV106TFLIqLegIteraciones_To), AV107TFLiqLegSegundos, AV108TFLiqLegSegundos_To});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brkAM2 = false ;
         A3CliCod = P00AM2_A3CliCod[0] ;
         A1EmpCod = P00AM2_A1EmpCod[0] ;
         A31LiqNro = P00AM2_A31LiqNro[0] ;
         A891LiqLegError = P00AM2_A891LiqLegError[0] ;
         A1780LiqLegAuxEstado = P00AM2_A1780LiqLegAuxEstado[0] ;
         A884LiqLegSegundos = P00AM2_A884LiqLegSegundos[0] ;
         A883LIqLegIteraciones = P00AM2_A883LIqLegIteraciones[0] ;
         A1157LiqLegImpContr = P00AM2_A1157LiqLegImpContr[0] ;
         A1781LiqLegErrorAux = P00AM2_A1781LiqLegErrorAux[0] ;
         A757LiqLegImpTotRetGan = P00AM2_A757LiqLegImpTotRetGan[0] ;
         A759LiqLegImpTotBruSinSAC = P00AM2_A759LiqLegImpTotBruSinSAC[0] ;
         A498LiqLegImpTotBruto = P00AM2_A498LiqLegImpTotBruto[0] ;
         A760LiqLegImpBasico = P00AM2_A760LiqLegImpBasico[0] ;
         A6LegNumero = P00AM2_A6LegNumero[0] ;
         AV25count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P00AM2_A891LiqLegError[0], A891LiqLegError) == 0 ) )
         {
            brkAM2 = false ;
            A3CliCod = P00AM2_A3CliCod[0] ;
            A1EmpCod = P00AM2_A1EmpCod[0] ;
            A31LiqNro = P00AM2_A31LiqNro[0] ;
            A6LegNumero = P00AM2_A6LegNumero[0] ;
            AV25count = (long)(AV25count+1) ;
            brkAM2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A891LiqLegError)==0) )
         {
            AV17Option = A891LiqLegError ;
            AV18Options.add(AV17Option, 0);
            AV23OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV25count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV18Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkAM2 )
         {
            brkAM2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADLIQLEGERRORAUXOPTIONS' Routine */
      returnInSub = false ;
      AV114TFLiqLegErrorAux = AV13SearchTxt ;
      AV115TFLiqLegErrorAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A891LiqLegError ,
                                           AV111TFLiqLegError_Sels ,
                                           A1781LiqLegErrorAux ,
                                           AV115TFLiqLegErrorAux_Sels ,
                                           Byte.valueOf(A1780LiqLegAuxEstado) ,
                                           AV117TFLiqLegAuxEstado_Sels ,
                                           AV93TFLiqLegImpBasico ,
                                           AV94TFLiqLegImpBasico_To ,
                                           AV82TFLiqLegImpTotBruto ,
                                           AV83TFLiqLegImpTotBruto_To ,
                                           AV91TFLiqLegImpTotBruSinSAC ,
                                           AV92TFLiqLegImpTotBruSinSAC_To ,
                                           AV87TFLiqLegImpTotRetGan ,
                                           AV88TFLiqLegImpTotRetGan_To ,
                                           Integer.valueOf(AV111TFLiqLegError_Sels.size()) ,
                                           AV110TFLiqLegError ,
                                           Integer.valueOf(AV115TFLiqLegErrorAux_Sels.size()) ,
                                           AV114TFLiqLegErrorAux ,
                                           AV101TFLiqLegImpContr ,
                                           AV102TFLiqLegImpContr_To ,
                                           Short.valueOf(AV105TFLIqLegIteraciones) ,
                                           Short.valueOf(AV106TFLIqLegIteraciones_To) ,
                                           AV107TFLiqLegSegundos ,
                                           AV108TFLiqLegSegundos_To ,
                                           Integer.valueOf(AV117TFLiqLegAuxEstado_Sels.size()) ,
                                           A760LiqLegImpBasico ,
                                           A498LiqLegImpTotBruto ,
                                           A759LiqLegImpTotBruSinSAC ,
                                           A757LiqLegImpTotRetGan ,
                                           A1157LiqLegImpContr ,
                                           Short.valueOf(A883LIqLegIteraciones) ,
                                           A884LiqLegSegundos ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV80CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(AV31EmpCod) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(AV32LiqNro) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV110TFLiqLegError = GXutil.concat( GXutil.rtrim( AV110TFLiqLegError), "%", "") ;
      lV114TFLiqLegErrorAux = GXutil.concat( GXutil.rtrim( AV114TFLiqLegErrorAux), "%", "") ;
      /* Using cursor P00AM3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV80CliCod), Short.valueOf(AV31EmpCod), Integer.valueOf(AV32LiqNro), AV93TFLiqLegImpBasico, AV94TFLiqLegImpBasico_To, AV82TFLiqLegImpTotBruto, AV83TFLiqLegImpTotBruto_To, AV91TFLiqLegImpTotBruSinSAC, AV92TFLiqLegImpTotBruSinSAC_To, AV87TFLiqLegImpTotRetGan, AV88TFLiqLegImpTotRetGan_To, lV110TFLiqLegError, lV114TFLiqLegErrorAux, AV101TFLiqLegImpContr, AV102TFLiqLegImpContr_To, Short.valueOf(AV105TFLIqLegIteraciones), Short.valueOf(AV106TFLIqLegIteraciones_To), AV107TFLiqLegSegundos, AV108TFLiqLegSegundos_To});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brkAM4 = false ;
         A3CliCod = P00AM3_A3CliCod[0] ;
         A1EmpCod = P00AM3_A1EmpCod[0] ;
         A31LiqNro = P00AM3_A31LiqNro[0] ;
         A1781LiqLegErrorAux = P00AM3_A1781LiqLegErrorAux[0] ;
         A1780LiqLegAuxEstado = P00AM3_A1780LiqLegAuxEstado[0] ;
         A884LiqLegSegundos = P00AM3_A884LiqLegSegundos[0] ;
         A883LIqLegIteraciones = P00AM3_A883LIqLegIteraciones[0] ;
         A1157LiqLegImpContr = P00AM3_A1157LiqLegImpContr[0] ;
         A891LiqLegError = P00AM3_A891LiqLegError[0] ;
         A757LiqLegImpTotRetGan = P00AM3_A757LiqLegImpTotRetGan[0] ;
         A759LiqLegImpTotBruSinSAC = P00AM3_A759LiqLegImpTotBruSinSAC[0] ;
         A498LiqLegImpTotBruto = P00AM3_A498LiqLegImpTotBruto[0] ;
         A760LiqLegImpBasico = P00AM3_A760LiqLegImpBasico[0] ;
         A6LegNumero = P00AM3_A6LegNumero[0] ;
         AV25count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P00AM3_A1781LiqLegErrorAux[0], A1781LiqLegErrorAux) == 0 ) )
         {
            brkAM4 = false ;
            A3CliCod = P00AM3_A3CliCod[0] ;
            A1EmpCod = P00AM3_A1EmpCod[0] ;
            A31LiqNro = P00AM3_A31LiqNro[0] ;
            A6LegNumero = P00AM3_A6LegNumero[0] ;
            AV25count = (long)(AV25count+1) ;
            brkAM4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1781LiqLegErrorAux)==0) )
         {
            AV17Option = A1781LiqLegErrorAux ;
            AV18Options.add(AV17Option, 0);
            AV23OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV25count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV18Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkAM4 )
         {
            brkAM4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = liquidacionlegajowcgetfilterdata.this.AV19OptionsJson;
      this.aP4[0] = liquidacionlegajowcgetfilterdata.this.AV22OptionsDescJson;
      this.aP5[0] = liquidacionlegajowcgetfilterdata.this.AV24OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19OptionsJson = "" ;
      AV22OptionsDescJson = "" ;
      AV24OptionIndexesJson = "" ;
      AV18Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV26Session = httpContext.getWebSession();
      AV28GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV29GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV93TFLiqLegImpBasico = DecimalUtil.ZERO ;
      AV94TFLiqLegImpBasico_To = DecimalUtil.ZERO ;
      AV82TFLiqLegImpTotBruto = DecimalUtil.ZERO ;
      AV83TFLiqLegImpTotBruto_To = DecimalUtil.ZERO ;
      AV91TFLiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      AV92TFLiqLegImpTotBruSinSAC_To = DecimalUtil.ZERO ;
      AV87TFLiqLegImpTotRetGan = DecimalUtil.ZERO ;
      AV88TFLiqLegImpTotRetGan_To = DecimalUtil.ZERO ;
      AV110TFLiqLegError = "" ;
      AV109TFLiqLegError_SelsJson = "" ;
      AV111TFLiqLegError_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV114TFLiqLegErrorAux = "" ;
      AV113TFLiqLegErrorAux_SelsJson = "" ;
      AV115TFLiqLegErrorAux_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV101TFLiqLegImpContr = DecimalUtil.ZERO ;
      AV102TFLiqLegImpContr_To = DecimalUtil.ZERO ;
      AV107TFLiqLegSegundos = DecimalUtil.ZERO ;
      AV108TFLiqLegSegundos_To = DecimalUtil.ZERO ;
      AV116TFLiqLegAuxEstado_SelsJson = "" ;
      AV117TFLiqLegAuxEstado_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV112MenuOpcCod = "" ;
      scmdbuf = "" ;
      lV110TFLiqLegError = "" ;
      lV114TFLiqLegErrorAux = "" ;
      A891LiqLegError = "" ;
      A1781LiqLegErrorAux = "" ;
      A760LiqLegImpBasico = DecimalUtil.ZERO ;
      A498LiqLegImpTotBruto = DecimalUtil.ZERO ;
      A759LiqLegImpTotBruSinSAC = DecimalUtil.ZERO ;
      A757LiqLegImpTotRetGan = DecimalUtil.ZERO ;
      A1157LiqLegImpContr = DecimalUtil.ZERO ;
      A884LiqLegSegundos = DecimalUtil.ZERO ;
      P00AM2_A3CliCod = new int[1] ;
      P00AM2_A1EmpCod = new short[1] ;
      P00AM2_A31LiqNro = new int[1] ;
      P00AM2_A891LiqLegError = new String[] {""} ;
      P00AM2_A1780LiqLegAuxEstado = new byte[1] ;
      P00AM2_A884LiqLegSegundos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00AM2_A883LIqLegIteraciones = new short[1] ;
      P00AM2_A1157LiqLegImpContr = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00AM2_A1781LiqLegErrorAux = new String[] {""} ;
      P00AM2_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00AM2_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00AM2_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00AM2_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00AM2_A6LegNumero = new int[1] ;
      AV17Option = "" ;
      P00AM3_A3CliCod = new int[1] ;
      P00AM3_A1EmpCod = new short[1] ;
      P00AM3_A31LiqNro = new int[1] ;
      P00AM3_A1781LiqLegErrorAux = new String[] {""} ;
      P00AM3_A1780LiqLegAuxEstado = new byte[1] ;
      P00AM3_A884LiqLegSegundos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00AM3_A883LIqLegIteraciones = new short[1] ;
      P00AM3_A1157LiqLegImpContr = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00AM3_A891LiqLegError = new String[] {""} ;
      P00AM3_A757LiqLegImpTotRetGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00AM3_A759LiqLegImpTotBruSinSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00AM3_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00AM3_A760LiqLegImpBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00AM3_A6LegNumero = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacionlegajowcgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00AM2_A3CliCod, P00AM2_A1EmpCod, P00AM2_A31LiqNro, P00AM2_A891LiqLegError, P00AM2_A1780LiqLegAuxEstado, P00AM2_A884LiqLegSegundos, P00AM2_A883LIqLegIteraciones, P00AM2_A1157LiqLegImpContr, P00AM2_A1781LiqLegErrorAux, P00AM2_A757LiqLegImpTotRetGan,
            P00AM2_A759LiqLegImpTotBruSinSAC, P00AM2_A498LiqLegImpTotBruto, P00AM2_A760LiqLegImpBasico, P00AM2_A6LegNumero
            }
            , new Object[] {
            P00AM3_A3CliCod, P00AM3_A1EmpCod, P00AM3_A31LiqNro, P00AM3_A1781LiqLegErrorAux, P00AM3_A1780LiqLegAuxEstado, P00AM3_A884LiqLegSegundos, P00AM3_A883LIqLegIteraciones, P00AM3_A1157LiqLegImpContr, P00AM3_A891LiqLegError, P00AM3_A757LiqLegImpTotRetGan,
            P00AM3_A759LiqLegImpTotBruSinSAC, P00AM3_A498LiqLegImpTotBruto, P00AM3_A760LiqLegImpBasico, P00AM3_A6LegNumero
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1780LiqLegAuxEstado ;
   private short AV105TFLIqLegIteraciones ;
   private short AV106TFLIqLegIteraciones_To ;
   private short AV31EmpCod ;
   private short A883LIqLegIteraciones ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV122GXV1 ;
   private int AV80CliCod ;
   private int AV32LiqNro ;
   private int AV111TFLiqLegError_Sels_size ;
   private int AV115TFLiqLegErrorAux_Sels_size ;
   private int AV117TFLiqLegAuxEstado_Sels_size ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private long AV25count ;
   private java.math.BigDecimal AV93TFLiqLegImpBasico ;
   private java.math.BigDecimal AV94TFLiqLegImpBasico_To ;
   private java.math.BigDecimal AV82TFLiqLegImpTotBruto ;
   private java.math.BigDecimal AV83TFLiqLegImpTotBruto_To ;
   private java.math.BigDecimal AV91TFLiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal AV92TFLiqLegImpTotBruSinSAC_To ;
   private java.math.BigDecimal AV87TFLiqLegImpTotRetGan ;
   private java.math.BigDecimal AV88TFLiqLegImpTotRetGan_To ;
   private java.math.BigDecimal AV101TFLiqLegImpContr ;
   private java.math.BigDecimal AV102TFLiqLegImpContr_To ;
   private java.math.BigDecimal AV107TFLiqLegSegundos ;
   private java.math.BigDecimal AV108TFLiqLegSegundos_To ;
   private java.math.BigDecimal A760LiqLegImpBasico ;
   private java.math.BigDecimal A498LiqLegImpTotBruto ;
   private java.math.BigDecimal A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal A1157LiqLegImpContr ;
   private java.math.BigDecimal A884LiqLegSegundos ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brkAM2 ;
   private boolean brkAM4 ;
   private String AV19OptionsJson ;
   private String AV22OptionsDescJson ;
   private String AV24OptionIndexesJson ;
   private String AV109TFLiqLegError_SelsJson ;
   private String AV113TFLiqLegErrorAux_SelsJson ;
   private String AV116TFLiqLegAuxEstado_SelsJson ;
   private String AV15DDOName ;
   private String AV13SearchTxt ;
   private String AV14SearchTxtTo ;
   private String AV110TFLiqLegError ;
   private String AV114TFLiqLegErrorAux ;
   private String AV112MenuOpcCod ;
   private String lV110TFLiqLegError ;
   private String lV114TFLiqLegErrorAux ;
   private String A891LiqLegError ;
   private String A1781LiqLegErrorAux ;
   private String AV17Option ;
   private GXSimpleCollection<Byte> AV117TFLiqLegAuxEstado_Sels ;
   private com.genexus.webpanels.WebSession AV26Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P00AM2_A3CliCod ;
   private short[] P00AM2_A1EmpCod ;
   private int[] P00AM2_A31LiqNro ;
   private String[] P00AM2_A891LiqLegError ;
   private byte[] P00AM2_A1780LiqLegAuxEstado ;
   private java.math.BigDecimal[] P00AM2_A884LiqLegSegundos ;
   private short[] P00AM2_A883LIqLegIteraciones ;
   private java.math.BigDecimal[] P00AM2_A1157LiqLegImpContr ;
   private String[] P00AM2_A1781LiqLegErrorAux ;
   private java.math.BigDecimal[] P00AM2_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] P00AM2_A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal[] P00AM2_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] P00AM2_A760LiqLegImpBasico ;
   private int[] P00AM2_A6LegNumero ;
   private int[] P00AM3_A3CliCod ;
   private short[] P00AM3_A1EmpCod ;
   private int[] P00AM3_A31LiqNro ;
   private String[] P00AM3_A1781LiqLegErrorAux ;
   private byte[] P00AM3_A1780LiqLegAuxEstado ;
   private java.math.BigDecimal[] P00AM3_A884LiqLegSegundos ;
   private short[] P00AM3_A883LIqLegIteraciones ;
   private java.math.BigDecimal[] P00AM3_A1157LiqLegImpContr ;
   private String[] P00AM3_A891LiqLegError ;
   private java.math.BigDecimal[] P00AM3_A757LiqLegImpTotRetGan ;
   private java.math.BigDecimal[] P00AM3_A759LiqLegImpTotBruSinSAC ;
   private java.math.BigDecimal[] P00AM3_A498LiqLegImpTotBruto ;
   private java.math.BigDecimal[] P00AM3_A760LiqLegImpBasico ;
   private int[] P00AM3_A6LegNumero ;
   private GXSimpleCollection<String> AV18Options ;
   private GXSimpleCollection<String> AV21OptionsDesc ;
   private GXSimpleCollection<String> AV23OptionIndexes ;
   private GXSimpleCollection<String> AV111TFLiqLegError_Sels ;
   private GXSimpleCollection<String> AV115TFLiqLegErrorAux_Sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV28GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV29GridStateFilterValue ;
}

final  class liquidacionlegajowcgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00AM2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A891LiqLegError ,
                                          GXSimpleCollection<String> AV111TFLiqLegError_Sels ,
                                          String A1781LiqLegErrorAux ,
                                          GXSimpleCollection<String> AV115TFLiqLegErrorAux_Sels ,
                                          byte A1780LiqLegAuxEstado ,
                                          GXSimpleCollection<Byte> AV117TFLiqLegAuxEstado_Sels ,
                                          java.math.BigDecimal AV93TFLiqLegImpBasico ,
                                          java.math.BigDecimal AV94TFLiqLegImpBasico_To ,
                                          java.math.BigDecimal AV82TFLiqLegImpTotBruto ,
                                          java.math.BigDecimal AV83TFLiqLegImpTotBruto_To ,
                                          java.math.BigDecimal AV91TFLiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal AV92TFLiqLegImpTotBruSinSAC_To ,
                                          java.math.BigDecimal AV87TFLiqLegImpTotRetGan ,
                                          java.math.BigDecimal AV88TFLiqLegImpTotRetGan_To ,
                                          int AV111TFLiqLegError_Sels_size ,
                                          String AV110TFLiqLegError ,
                                          int AV115TFLiqLegErrorAux_Sels_size ,
                                          String AV114TFLiqLegErrorAux ,
                                          java.math.BigDecimal AV101TFLiqLegImpContr ,
                                          java.math.BigDecimal AV102TFLiqLegImpContr_To ,
                                          short AV105TFLIqLegIteraciones ,
                                          short AV106TFLIqLegIteraciones_To ,
                                          java.math.BigDecimal AV107TFLiqLegSegundos ,
                                          java.math.BigDecimal AV108TFLiqLegSegundos_To ,
                                          int AV117TFLiqLegAuxEstado_Sels_size ,
                                          java.math.BigDecimal A760LiqLegImpBasico ,
                                          java.math.BigDecimal A498LiqLegImpTotBruto ,
                                          java.math.BigDecimal A759LiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal A757LiqLegImpTotRetGan ,
                                          java.math.BigDecimal A1157LiqLegImpContr ,
                                          short A883LIqLegIteraciones ,
                                          java.math.BigDecimal A884LiqLegSegundos ,
                                          int A3CliCod ,
                                          int AV80CliCod ,
                                          short A1EmpCod ,
                                          short AV31EmpCod ,
                                          int A31LiqNro ,
                                          int AV32LiqNro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[19];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, LiqNro, LiqLegError, LiqLegAuxEstado, LiqLegSegundos, LIqLegIteraciones, LiqLegImpContr, LiqLegErrorAux, LiqLegImpTotRetGan, LiqLegImpTotBruSinSAC," ;
      scmdbuf += " LiqLegImpTotBruto, LiqLegImpBasico, LegNumero FROM LiquidacionLegajo" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      addWhere(sWhereString, "(LiqNro = ?)");
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV93TFLiqLegImpBasico)==0) )
      {
         addWhere(sWhereString, "(LiqLegImpBasico >= ?)");
      }
      else
      {
         GXv_int4[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV94TFLiqLegImpBasico_To)==0) )
      {
         addWhere(sWhereString, "(LiqLegImpBasico <= ?)");
      }
      else
      {
         GXv_int4[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV82TFLiqLegImpTotBruto)==0) )
      {
         addWhere(sWhereString, "(LiqLegImpTotBruto >= ?)");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV83TFLiqLegImpTotBruto_To)==0) )
      {
         addWhere(sWhereString, "(LiqLegImpTotBruto <= ?)");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV91TFLiqLegImpTotBruSinSAC)==0) )
      {
         addWhere(sWhereString, "(LiqLegImpTotBruSinSAC >= ?)");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV92TFLiqLegImpTotBruSinSAC_To)==0) )
      {
         addWhere(sWhereString, "(LiqLegImpTotBruSinSAC <= ?)");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV87TFLiqLegImpTotRetGan)==0) )
      {
         addWhere(sWhereString, "(LiqLegImpTotRetGan >= ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV88TFLiqLegImpTotRetGan_To)==0) )
      {
         addWhere(sWhereString, "(LiqLegImpTotRetGan <= ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ( AV111TFLiqLegError_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV110TFLiqLegError)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqLegError) like LOWER(?))");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( AV111TFLiqLegError_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV111TFLiqLegError_Sels, "LiqLegError IN (", ")")+")");
      }
      if ( ( AV115TFLiqLegErrorAux_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV114TFLiqLegErrorAux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqLegErrorAux) like LOWER(?))");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( AV115TFLiqLegErrorAux_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV115TFLiqLegErrorAux_Sels, "LiqLegErrorAux IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV101TFLiqLegImpContr)==0) )
      {
         addWhere(sWhereString, "(LiqLegImpContr >= ?)");
      }
      else
      {
         GXv_int4[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV102TFLiqLegImpContr_To)==0) )
      {
         addWhere(sWhereString, "(LiqLegImpContr <= ?)");
      }
      else
      {
         GXv_int4[14] = (byte)(1) ;
      }
      if ( ! (0==AV105TFLIqLegIteraciones) )
      {
         addWhere(sWhereString, "(LIqLegIteraciones >= ?)");
      }
      else
      {
         GXv_int4[15] = (byte)(1) ;
      }
      if ( ! (0==AV106TFLIqLegIteraciones_To) )
      {
         addWhere(sWhereString, "(LIqLegIteraciones <= ?)");
      }
      else
      {
         GXv_int4[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV107TFLiqLegSegundos)==0) )
      {
         addWhere(sWhereString, "(LiqLegSegundos >= ?)");
      }
      else
      {
         GXv_int4[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV108TFLiqLegSegundos_To)==0) )
      {
         addWhere(sWhereString, "(LiqLegSegundos <= ?)");
      }
      else
      {
         GXv_int4[18] = (byte)(1) ;
      }
      if ( AV117TFLiqLegAuxEstado_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV117TFLiqLegAuxEstado_Sels, "LiqLegAuxEstado IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY LiqLegError" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P00AM3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A891LiqLegError ,
                                          GXSimpleCollection<String> AV111TFLiqLegError_Sels ,
                                          String A1781LiqLegErrorAux ,
                                          GXSimpleCollection<String> AV115TFLiqLegErrorAux_Sels ,
                                          byte A1780LiqLegAuxEstado ,
                                          GXSimpleCollection<Byte> AV117TFLiqLegAuxEstado_Sels ,
                                          java.math.BigDecimal AV93TFLiqLegImpBasico ,
                                          java.math.BigDecimal AV94TFLiqLegImpBasico_To ,
                                          java.math.BigDecimal AV82TFLiqLegImpTotBruto ,
                                          java.math.BigDecimal AV83TFLiqLegImpTotBruto_To ,
                                          java.math.BigDecimal AV91TFLiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal AV92TFLiqLegImpTotBruSinSAC_To ,
                                          java.math.BigDecimal AV87TFLiqLegImpTotRetGan ,
                                          java.math.BigDecimal AV88TFLiqLegImpTotRetGan_To ,
                                          int AV111TFLiqLegError_Sels_size ,
                                          String AV110TFLiqLegError ,
                                          int AV115TFLiqLegErrorAux_Sels_size ,
                                          String AV114TFLiqLegErrorAux ,
                                          java.math.BigDecimal AV101TFLiqLegImpContr ,
                                          java.math.BigDecimal AV102TFLiqLegImpContr_To ,
                                          short AV105TFLIqLegIteraciones ,
                                          short AV106TFLIqLegIteraciones_To ,
                                          java.math.BigDecimal AV107TFLiqLegSegundos ,
                                          java.math.BigDecimal AV108TFLiqLegSegundos_To ,
                                          int AV117TFLiqLegAuxEstado_Sels_size ,
                                          java.math.BigDecimal A760LiqLegImpBasico ,
                                          java.math.BigDecimal A498LiqLegImpTotBruto ,
                                          java.math.BigDecimal A759LiqLegImpTotBruSinSAC ,
                                          java.math.BigDecimal A757LiqLegImpTotRetGan ,
                                          java.math.BigDecimal A1157LiqLegImpContr ,
                                          short A883LIqLegIteraciones ,
                                          java.math.BigDecimal A884LiqLegSegundos ,
                                          int A3CliCod ,
                                          int AV80CliCod ,
                                          short A1EmpCod ,
                                          short AV31EmpCod ,
                                          int A31LiqNro ,
                                          int AV32LiqNro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[19];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, LiqNro, LiqLegErrorAux, LiqLegAuxEstado, LiqLegSegundos, LIqLegIteraciones, LiqLegImpContr, LiqLegError, LiqLegImpTotRetGan, LiqLegImpTotBruSinSAC," ;
      scmdbuf += " LiqLegImpTotBruto, LiqLegImpBasico, LegNumero FROM LiquidacionLegajo" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      addWhere(sWhereString, "(LiqNro = ?)");
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV93TFLiqLegImpBasico)==0) )
      {
         addWhere(sWhereString, "(LiqLegImpBasico >= ?)");
      }
      else
      {
         GXv_int7[3] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV94TFLiqLegImpBasico_To)==0) )
      {
         addWhere(sWhereString, "(LiqLegImpBasico <= ?)");
      }
      else
      {
         GXv_int7[4] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV82TFLiqLegImpTotBruto)==0) )
      {
         addWhere(sWhereString, "(LiqLegImpTotBruto >= ?)");
      }
      else
      {
         GXv_int7[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV83TFLiqLegImpTotBruto_To)==0) )
      {
         addWhere(sWhereString, "(LiqLegImpTotBruto <= ?)");
      }
      else
      {
         GXv_int7[6] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV91TFLiqLegImpTotBruSinSAC)==0) )
      {
         addWhere(sWhereString, "(LiqLegImpTotBruSinSAC >= ?)");
      }
      else
      {
         GXv_int7[7] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV92TFLiqLegImpTotBruSinSAC_To)==0) )
      {
         addWhere(sWhereString, "(LiqLegImpTotBruSinSAC <= ?)");
      }
      else
      {
         GXv_int7[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV87TFLiqLegImpTotRetGan)==0) )
      {
         addWhere(sWhereString, "(LiqLegImpTotRetGan >= ?)");
      }
      else
      {
         GXv_int7[9] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV88TFLiqLegImpTotRetGan_To)==0) )
      {
         addWhere(sWhereString, "(LiqLegImpTotRetGan <= ?)");
      }
      else
      {
         GXv_int7[10] = (byte)(1) ;
      }
      if ( ( AV111TFLiqLegError_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV110TFLiqLegError)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqLegError) like LOWER(?))");
      }
      else
      {
         GXv_int7[11] = (byte)(1) ;
      }
      if ( AV111TFLiqLegError_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV111TFLiqLegError_Sels, "LiqLegError IN (", ")")+")");
      }
      if ( ( AV115TFLiqLegErrorAux_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV114TFLiqLegErrorAux)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LiqLegErrorAux) like LOWER(?))");
      }
      else
      {
         GXv_int7[12] = (byte)(1) ;
      }
      if ( AV115TFLiqLegErrorAux_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV115TFLiqLegErrorAux_Sels, "LiqLegErrorAux IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV101TFLiqLegImpContr)==0) )
      {
         addWhere(sWhereString, "(LiqLegImpContr >= ?)");
      }
      else
      {
         GXv_int7[13] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV102TFLiqLegImpContr_To)==0) )
      {
         addWhere(sWhereString, "(LiqLegImpContr <= ?)");
      }
      else
      {
         GXv_int7[14] = (byte)(1) ;
      }
      if ( ! (0==AV105TFLIqLegIteraciones) )
      {
         addWhere(sWhereString, "(LIqLegIteraciones >= ?)");
      }
      else
      {
         GXv_int7[15] = (byte)(1) ;
      }
      if ( ! (0==AV106TFLIqLegIteraciones_To) )
      {
         addWhere(sWhereString, "(LIqLegIteraciones <= ?)");
      }
      else
      {
         GXv_int7[16] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV107TFLiqLegSegundos)==0) )
      {
         addWhere(sWhereString, "(LiqLegSegundos >= ?)");
      }
      else
      {
         GXv_int7[17] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV108TFLiqLegSegundos_To)==0) )
      {
         addWhere(sWhereString, "(LiqLegSegundos <= ?)");
      }
      else
      {
         GXv_int7[18] = (byte)(1) ;
      }
      if ( AV117TFLiqLegAuxEstado_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV117TFLiqLegAuxEstado_Sels, "LiqLegAuxEstado IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY LiqLegErrorAux" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
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
                  return conditional_P00AM2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).shortValue() , (java.math.BigDecimal)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , (java.math.BigDecimal)dynConstraints[28] , (java.math.BigDecimal)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , (java.math.BigDecimal)dynConstraints[31] , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).shortValue() , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() );
            case 1 :
                  return conditional_P00AM3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (java.math.BigDecimal)dynConstraints[6] , (java.math.BigDecimal)dynConstraints[7] , (java.math.BigDecimal)dynConstraints[8] , (java.math.BigDecimal)dynConstraints[9] , (java.math.BigDecimal)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , (java.math.BigDecimal)dynConstraints[18] , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).shortValue() , (java.math.BigDecimal)dynConstraints[22] , (java.math.BigDecimal)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , (java.math.BigDecimal)dynConstraints[25] , (java.math.BigDecimal)dynConstraints[26] , (java.math.BigDecimal)dynConstraints[27] , (java.math.BigDecimal)dynConstraints[28] , (java.math.BigDecimal)dynConstraints[29] , ((Number) dynConstraints[30]).shortValue() , (java.math.BigDecimal)dynConstraints[31] , ((Number) dynConstraints[32]).intValue() , ((Number) dynConstraints[33]).intValue() , ((Number) dynConstraints[34]).shortValue() , ((Number) dynConstraints[35]).shortValue() , ((Number) dynConstraints[36]).intValue() , ((Number) dynConstraints[37]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00AM2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00AM3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               ((int[]) buf[13])[0] = rslt.getInt(14);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               ((int[]) buf[13])[0] = rslt.getInt(14);
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
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 2);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[27], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 400);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 400);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[32], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[33], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[34]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[35]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 6);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 6);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[20]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[22], 2);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[23], 2);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[24], 2);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[25], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[26], 2);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[27], 2);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[28], 2);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[29], 2);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[30], 400);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[31], 400);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[32], 2);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[33], 2);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[34]).shortValue());
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[35]).shortValue());
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[36], 6);
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[37], 6);
               }
               return;
      }
   }

}

