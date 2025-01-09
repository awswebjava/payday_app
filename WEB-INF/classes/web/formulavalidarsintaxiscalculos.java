package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class formulavalidarsintaxiscalculos extends GXProcedure
{
   public formulavalidarsintaxiscalculos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( formulavalidarsintaxiscalculos.class ), "" );
   }

   public formulavalidarsintaxiscalculos( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 )
   {
      formulavalidarsintaxiscalculos.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 )
   {
      formulavalidarsintaxiscalculos.this.AV17CliCod = aP0;
      formulavalidarsintaxiscalculos.this.AV16ConCodigo = aP1;
      formulavalidarsintaxiscalculos.this.AV9ConFormula = aP2;
      formulavalidarsintaxiscalculos.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_objcol_SdtSDTOperandosFormula1 = AV10SDTOperandos ;
      GXv_objcol_SdtSDTOperandosFormula2[0] = GXt_objcol_SdtSDTOperandosFormula1 ;
      new web.obtoperandosformula(remoteHandle, context).execute( AV17CliCod, AV16ConCodigo, AV9ConFormula, DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), GXv_objcol_SdtSDTOperandosFormula2) ;
      GXt_objcol_SdtSDTOperandosFormula1 = GXv_objcol_SdtSDTOperandosFormula2[0] ;
      AV10SDTOperandos = GXt_objcol_SdtSDTOperandosFormula1 ;
      AV20GXV1 = 1 ;
      while ( AV20GXV1 <= AV10SDTOperandos.size() )
      {
         AV11SDTOperandosItem = (web.SdtSDTOperandosFormula)((web.SdtSDTOperandosFormula)AV10SDTOperandos.elementAt(-1+AV20GXV1));
         AV13idOperando = "" ;
         GXv_char3[0] = AV12Operando ;
         GXv_char4[0] = AV8primeraPalabra ;
         new web.opeformulaapalabramayuscula(remoteHandle, context).execute( AV11SDTOperandosItem.getgxTv_SdtSDTOperandosFormula_Operandooriginal(), GXv_char3, GXv_char4) ;
         formulavalidarsintaxiscalculos.this.AV12Operando = GXv_char3[0] ;
         formulavalidarsintaxiscalculos.this.AV8primeraPalabra = GXv_char4[0] ;
         GXv_char4[0] = AV13idOperando ;
         GXv_char3[0] = "" ;
         GXv_char5[0] = "" ;
         GXv_boolean6[0] = false ;
         GXv_boolean7[0] = false ;
         new web.codigoopeformulaiddescyfor(remoteHandle, context).execute( AV17CliCod, AV8primeraPalabra, GXv_char4, GXv_char3, GXv_char5, GXv_boolean6, GXv_boolean7) ;
         formulavalidarsintaxiscalculos.this.AV13idOperando = GXv_char4[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "!! &Operando ", "")+GXutil.trim( AV12Operando)+httpContext.getMessage( " &idOperando ", "")+AV13idOperando) ;
         if ( ! (GXutil.strcmp("", AV13idOperando)==0) )
         {
            GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem8[0] = AV14cal_par_valores ;
            GXv_char5[0] = AV15error ;
            new web.devuelveparametroscc4(remoteHandle, context).execute( AV17CliCod, AV13idOperando, AV12Operando, GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem8, GXv_char5) ;
            AV14cal_par_valores = GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem8[0] ;
            formulavalidarsintaxiscalculos.this.AV15error = GXv_char5[0] ;
            if ( ! (GXutil.strcmp("", AV15error)==0) )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         AV20GXV1 = (int)(AV20GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = formulavalidarsintaxiscalculos.this.AV15error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15error = "" ;
      AV10SDTOperandos = new GXBaseCollection<web.SdtSDTOperandosFormula>(web.SdtSDTOperandosFormula.class, "SDTOperandosFormula", "PayDay", remoteHandle);
      GXt_objcol_SdtSDTOperandosFormula1 = new GXBaseCollection<web.SdtSDTOperandosFormula>(web.SdtSDTOperandosFormula.class, "SDTOperandosFormula", "PayDay", remoteHandle);
      GXv_objcol_SdtSDTOperandosFormula2 = new GXBaseCollection[1] ;
      AV11SDTOperandosItem = new web.SdtSDTOperandosFormula(remoteHandle, context);
      AV13idOperando = "" ;
      AV12Operando = "" ;
      AV8primeraPalabra = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXv_boolean7 = new boolean[1] ;
      AV21Pgmname = "" ;
      AV14cal_par_valores = new GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>(web.Sdtcal_par_valores_cal_par_valoresItem.class, "cal_par_valoresItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem8 = new GXBaseCollection[1] ;
      GXv_char5 = new String[1] ;
      AV21Pgmname = "formulaValidarSintaxisCalculos" ;
      /* GeneXus formulas. */
      AV21Pgmname = "formulaValidarSintaxisCalculos" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV17CliCod ;
   private int AV20GXV1 ;
   private String AV16ConCodigo ;
   private String AV13idOperando ;
   private String AV8primeraPalabra ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private String AV21Pgmname ;
   private String GXv_char5[] ;
   private boolean GXv_boolean6[] ;
   private boolean GXv_boolean7[] ;
   private boolean returnInSub ;
   private String AV9ConFormula ;
   private String AV15error ;
   private String AV12Operando ;
   private String[] aP3 ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> AV10SDTOperandos ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> GXt_objcol_SdtSDTOperandosFormula1 ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> GXv_objcol_SdtSDTOperandosFormula2[] ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> AV14cal_par_valores ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem8[] ;
   private web.SdtSDTOperandosFormula AV11SDTOperandosItem ;
}

