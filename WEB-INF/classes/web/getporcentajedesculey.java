package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getporcentajedesculey extends GXProcedure
{
   public getporcentajedesculey( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getporcentajedesculey.class ), "" );
   }

   public getporcentajedesculey( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             boolean aP4 ,
                             boolean aP5 ,
                             String aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             String[] aP9 )
   {
      getporcentajedesculey.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        boolean aP4 ,
                        boolean aP5 ,
                        String aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        String[] aP9 ,
                        String[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             boolean aP4 ,
                             boolean aP5 ,
                             String aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 )
   {
      getporcentajedesculey.this.AV8CliCod = aP0;
      getporcentajedesculey.this.AV15EmpCod = aP1;
      getporcentajedesculey.this.AV10LegNumero = aP2;
      getporcentajedesculey.this.AV28fecha = aP3;
      getporcentajedesculey.this.AV11parmLegLiqApo = aP4;
      getporcentajedesculey.this.AV12parmLegJubilado = aP5;
      getporcentajedesculey.this.AV13parmSinCod = aP6;
      getporcentajedesculey.this.aP7 = aP7;
      getporcentajedesculey.this.aP8 = aP8;
      getporcentajedesculey.this.aP9 = aP9;
      getporcentajedesculey.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV19jubilacionConCodigo ;
      GXv_char2[0] = GXt_char1 ;
      new web.codigoconceptojubilacion(remoteHandle, context).execute( AV8CliCod, GXv_char2) ;
      getporcentajedesculey.this.GXt_char1 = GXv_char2[0] ;
      AV19jubilacionConCodigo = GXt_char1 ;
      GXt_char1 = AV23obraSocialConCodigo ;
      GXt_char3 = AV23obraSocialConCodigo ;
      GXv_char2[0] = GXt_char3 ;
      new web.concepto_obrasocial_codigoparam(remoteHandle, context).execute( GXv_char2) ;
      getporcentajedesculey.this.GXt_char3 = GXv_char2[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char3, GXv_char4) ;
      getporcentajedesculey.this.GXt_char1 = GXv_char4[0] ;
      AV23obraSocialConCodigo = GXt_char1 ;
      GXt_char3 = AV20pamiConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.codigoconceptopami(remoteHandle, context).execute( AV8CliCod, GXv_char4) ;
      getporcentajedesculey.this.GXt_char3 = GXv_char4[0] ;
      AV20pamiConCodigo = GXt_char3 ;
      GXt_char3 = AV26cuotaSindicalConCodigo ;
      GXv_char4[0] = GXt_char3 ;
      new web.codigoconceptocuotasindical(remoteHandle, context).execute( AV8CliCod, GXv_char4) ;
      getporcentajedesculey.this.GXt_char3 = GXv_char4[0] ;
      AV26cuotaSindicalConCodigo = GXt_char3 ;
      AV39GXLvl9 = (byte)(0) ;
      /* Using cursor P02D32 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A37TipoConCod = P02D32_A37TipoConCod[0] ;
         A150ConHabilitado = P02D32_A150ConHabilitado[0] ;
         A740SubTDescuLey = P02D32_A740SubTDescuLey[0] ;
         A3CliCod = P02D32_A3CliCod[0] ;
         A26ConCodigo = P02D32_A26ConCodigo[0] ;
         A38SubTipoConCod1 = P02D32_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = P02D32_n38SubTipoConCod1[0] ;
         A39SubTipoConCod2 = P02D32_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = P02D32_n39SubTipoConCod2[0] ;
         A148ConFormula = P02D32_A148ConFormula[0] ;
         n148ConFormula = P02D32_n148ConFormula[0] ;
         A41ConDescrip = P02D32_A41ConDescrip[0] ;
         A740SubTDescuLey = P02D32_A740SubTDescuLey[0] ;
         AV39GXLvl9 = (byte)(1) ;
         AV9validarLiqDLog = "" ;
         if ( (0==AV10LegNumero) )
         {
            GXv_char4[0] = AV9validarLiqDLog ;
            GXv_int5[0] = (short)((byte)((AV14entra)?1:0)) ;
            new web.validarcondicionesdesculey(remoteHandle, context).execute( AV8CliCod, A26ConCodigo, AV11parmLegLiqApo, AV12parmLegJubilado, AV13parmSinCod, GXv_char4, GXv_int5) ;
            getporcentajedesculey.this.AV9validarLiqDLog = GXv_char4[0] ;
            getporcentajedesculey.this.AV14entra = (boolean)((GXv_int5[0]==0)?false:true) ;
         }
         else
         {
            GXv_boolean6[0] = AV14entra ;
            GXv_boolean7[0] = false ;
            GXv_char4[0] = AV17ConCondicion ;
            GXv_char2[0] = AV9validarLiqDLog ;
            new web.validarconcepto2(remoteHandle, context).execute( AV8CliCod, AV15EmpCod, 0, AV10LegNumero, AV16LegSuelFecha, false, A38SubTipoConCod1, A39SubTipoConCod2, false, A26ConCodigo, false, A148ConFormula, A41ConDescrip, "", "", "", false, "Calculo", false, GXv_boolean6, GXv_boolean7, GXv_char4, GXv_char2) ;
            getporcentajedesculey.this.AV14entra = GXv_boolean6[0] ;
            getporcentajedesculey.this.AV17ConCondicion = GXv_char4[0] ;
            getporcentajedesculey.this.AV9validarLiqDLog = GXv_char2[0] ;
         }
         AV34LiqDLog += ". " + GXutil.trim( A26ConCodigo) + httpContext.getMessage( " entra ", "") + GXutil.trim( GXutil.booltostr( AV14entra)) + " (" + GXutil.trim( AV9validarLiqDLog) + ")" ;
         if ( AV14entra )
         {
            if ( GXutil.strcmp(A26ConCodigo, AV19jubilacionConCodigo) == 0 )
            {
               AV27OpeCliId = "[apo_jub_ali]" ;
               /* Execute user subroutine: 'GET OPECLI' */
               S121 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV21jubilacionPorUnaje = CommonUtil.decimalVal( AV29OpeCliValor, ".") ;
               AV18porUnaje = AV18porUnaje.add(AV21jubilacionPorUnaje) ;
               AV34LiqDLog += httpContext.getMessage( " suma &jubilacionPorUnaje ", "") + GXutil.trim( GXutil.str( AV21jubilacionPorUnaje, 6, 4)) ;
            }
            else if ( GXutil.strcmp(A26ConCodigo, AV20pamiConCodigo) == 0 )
            {
               AV27OpeCliId = "[apo_INSSJyP_ali]" ;
               /* Execute user subroutine: 'GET OPECLI' */
               S121 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV22pamiPorUnaje = CommonUtil.decimalVal( AV29OpeCliValor, ".") ;
               AV18porUnaje = AV18porUnaje.add(AV22pamiPorUnaje) ;
               AV34LiqDLog += httpContext.getMessage( " suma &&pamiPorUnaje ", "") + GXutil.trim( GXutil.str( AV22pamiPorUnaje, 6, 4)) ;
            }
            else if ( GXutil.strcmp(A26ConCodigo, AV23obraSocialConCodigo) == 0 )
            {
               AV27OpeCliId = "[apo_OS_ali]" ;
               /* Execute user subroutine: 'GET OPECLI' */
               S121 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV24obraSocialPorUnaje = CommonUtil.decimalVal( AV29OpeCliValor, ".") ;
               AV18porUnaje = AV18porUnaje.add(AV24obraSocialPorUnaje) ;
               AV34LiqDLog += httpContext.getMessage( " suma &&obraSocialPorUnaje ", "") + GXutil.trim( GXutil.str( AV24obraSocialPorUnaje, 6, 4)) ;
            }
            else if ( GXutil.strcmp(A26ConCodigo, AV26cuotaSindicalConCodigo) == 0 )
            {
               if ( (0==AV10LegNumero) )
               {
                  AV32SinCod = AV13parmSinCod ;
               }
               else
               {
                  GXv_char4[0] = AV32SinCod ;
                  new web.empleadogetsindicato(remoteHandle, context).execute( AV8CliCod, AV15EmpCod, AV10LegNumero, GXv_char4) ;
                  getporcentajedesculey.this.AV32SinCod = GXv_char4[0] ;
               }
               GXv_decimal8[0] = AV25cuotaSindicalPorUnaje ;
               GXv_boolean7[0] = false ;
               new web.getsindicatocuota(remoteHandle, context).execute( AV8CliCod, AV32SinCod, GXv_decimal8, GXv_boolean7) ;
               getporcentajedesculey.this.AV25cuotaSindicalPorUnaje = GXv_decimal8[0] ;
               AV36sinTopePorUnaje = AV36sinTopePorUnaje.add(AV25cuotaSindicalPorUnaje) ;
               AV34LiqDLog += httpContext.getMessage( " suma &&cuotaSindicalPorUnaje ", "") + GXutil.trim( GXutil.str( AV25cuotaSindicalPorUnaje, 6, 4)) ;
            }
            else
            {
               AV34LiqDLog += httpContext.getMessage( " concodigo ", "") + GXutil.trim( A26ConCodigo) + httpContext.getMessage( " no suma nada", "") ;
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV39GXLvl9 == 0 )
      {
         AV34LiqDLog = httpContext.getMessage( "none", "") ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'ERROR' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV30auxError)==0) )
      {
         AV31error = GXutil.trim( AV30auxError) ;
         returnInSub = true;
         if (true) return;
      }
   }

   public void S121( )
   {
      /* 'GET OPECLI' Routine */
      returnInSub = false ;
      GXv_char4[0] = AV29OpeCliValor ;
      GXv_char2[0] = AV30auxError ;
      new web.getopeclivalor(remoteHandle, context).execute( AV8CliCod, AV27OpeCliId, AV28fecha, "Calculo", GXv_char4, GXv_char2) ;
      getporcentajedesculey.this.AV29OpeCliValor = GXv_char4[0] ;
      getporcentajedesculey.this.AV30auxError = GXv_char2[0] ;
      if ( (GXutil.strcmp("", AV30auxError)==0) && (GXutil.strcmp("", AV29OpeCliValor)==0) )
      {
         AV30auxError = GXutil.trim( AV27OpeCliId) + httpContext.getMessage( " sin valor", "") ;
      }
      /* Execute user subroutine: 'ERROR' */
      S111 ();
      if (returnInSub) return;
   }

   protected void cleanup( )
   {
      this.aP7[0] = getporcentajedesculey.this.AV18porUnaje;
      this.aP8[0] = getporcentajedesculey.this.AV36sinTopePorUnaje;
      this.aP9[0] = getporcentajedesculey.this.AV31error;
      this.aP10[0] = getporcentajedesculey.this.AV34LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18porUnaje = DecimalUtil.ZERO ;
      AV36sinTopePorUnaje = DecimalUtil.ZERO ;
      AV31error = "" ;
      AV34LiqDLog = "" ;
      AV19jubilacionConCodigo = "" ;
      AV23obraSocialConCodigo = "" ;
      GXt_char1 = "" ;
      AV20pamiConCodigo = "" ;
      AV26cuotaSindicalConCodigo = "" ;
      GXt_char3 = "" ;
      scmdbuf = "" ;
      P02D32_A37TipoConCod = new String[] {""} ;
      P02D32_A150ConHabilitado = new boolean[] {false} ;
      P02D32_A740SubTDescuLey = new boolean[] {false} ;
      P02D32_A3CliCod = new int[1] ;
      P02D32_A26ConCodigo = new String[] {""} ;
      P02D32_A38SubTipoConCod1 = new String[] {""} ;
      P02D32_n38SubTipoConCod1 = new boolean[] {false} ;
      P02D32_A39SubTipoConCod2 = new String[] {""} ;
      P02D32_n39SubTipoConCod2 = new boolean[] {false} ;
      P02D32_A148ConFormula = new String[] {""} ;
      P02D32_n148ConFormula = new boolean[] {false} ;
      P02D32_A41ConDescrip = new String[] {""} ;
      A37TipoConCod = "" ;
      A26ConCodigo = "" ;
      A38SubTipoConCod1 = "" ;
      A39SubTipoConCod2 = "" ;
      A148ConFormula = "" ;
      A41ConDescrip = "" ;
      AV9validarLiqDLog = "" ;
      GXv_int5 = new short[1] ;
      AV16LegSuelFecha = GXutil.nullDate() ;
      GXv_boolean6 = new boolean[1] ;
      AV17ConCondicion = "" ;
      AV27OpeCliId = "" ;
      AV21jubilacionPorUnaje = DecimalUtil.ZERO ;
      AV29OpeCliValor = "" ;
      AV22pamiPorUnaje = DecimalUtil.ZERO ;
      AV24obraSocialPorUnaje = DecimalUtil.ZERO ;
      AV32SinCod = "" ;
      AV25cuotaSindicalPorUnaje = DecimalUtil.ZERO ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      GXv_boolean7 = new boolean[1] ;
      AV30auxError = "" ;
      GXv_char4 = new String[1] ;
      GXv_char2 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getporcentajedesculey__default(),
         new Object[] {
             new Object[] {
            P02D32_A37TipoConCod, P02D32_A150ConHabilitado, P02D32_A740SubTDescuLey, P02D32_A3CliCod, P02D32_A26ConCodigo, P02D32_A38SubTipoConCod1, P02D32_n38SubTipoConCod1, P02D32_A39SubTipoConCod2, P02D32_n39SubTipoConCod2, P02D32_A148ConFormula,
            P02D32_n148ConFormula, P02D32_A41ConDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV39GXLvl9 ;
   private short AV15EmpCod ;
   private short GXv_int5[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV18porUnaje ;
   private java.math.BigDecimal AV36sinTopePorUnaje ;
   private java.math.BigDecimal AV21jubilacionPorUnaje ;
   private java.math.BigDecimal AV22pamiPorUnaje ;
   private java.math.BigDecimal AV24obraSocialPorUnaje ;
   private java.math.BigDecimal AV25cuotaSindicalPorUnaje ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private String AV13parmSinCod ;
   private String AV19jubilacionConCodigo ;
   private String AV23obraSocialConCodigo ;
   private String GXt_char1 ;
   private String AV20pamiConCodigo ;
   private String AV26cuotaSindicalConCodigo ;
   private String GXt_char3 ;
   private String scmdbuf ;
   private String A37TipoConCod ;
   private String A26ConCodigo ;
   private String A38SubTipoConCod1 ;
   private String A39SubTipoConCod2 ;
   private String AV17ConCondicion ;
   private String AV27OpeCliId ;
   private String AV32SinCod ;
   private String GXv_char4[] ;
   private String GXv_char2[] ;
   private java.util.Date AV28fecha ;
   private java.util.Date AV16LegSuelFecha ;
   private boolean AV11parmLegLiqApo ;
   private boolean AV12parmLegJubilado ;
   private boolean A150ConHabilitado ;
   private boolean A740SubTDescuLey ;
   private boolean n38SubTipoConCod1 ;
   private boolean n39SubTipoConCod2 ;
   private boolean n148ConFormula ;
   private boolean AV14entra ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean GXv_boolean7[] ;
   private String AV34LiqDLog ;
   private String A148ConFormula ;
   private String AV9validarLiqDLog ;
   private String AV29OpeCliValor ;
   private String AV31error ;
   private String A41ConDescrip ;
   private String AV30auxError ;
   private String[] aP10 ;
   private java.math.BigDecimal[] aP7 ;
   private java.math.BigDecimal[] aP8 ;
   private String[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P02D32_A37TipoConCod ;
   private boolean[] P02D32_A150ConHabilitado ;
   private boolean[] P02D32_A740SubTDescuLey ;
   private int[] P02D32_A3CliCod ;
   private String[] P02D32_A26ConCodigo ;
   private String[] P02D32_A38SubTipoConCod1 ;
   private boolean[] P02D32_n38SubTipoConCod1 ;
   private String[] P02D32_A39SubTipoConCod2 ;
   private boolean[] P02D32_n39SubTipoConCod2 ;
   private String[] P02D32_A148ConFormula ;
   private boolean[] P02D32_n148ConFormula ;
   private String[] P02D32_A41ConDescrip ;
}

final  class getporcentajedesculey__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02D32", "SELECT T1.TipoConCod, T1.ConHabilitado, T2.SubTDescuLey, T1.CliCod, T1.ConCodigo, T1.SubTipoConCod1, T1.SubTipoConCod2, T1.ConFormula, T1.ConDescrip FROM (Concepto T1 LEFT JOIN TipoDeConceptoSubtipo1 T2 ON T2.TipoConCod = T1.TipoConCod AND T2.SubTipoConCod1 = T1.SubTipoConCod1) WHERE (T1.CliCod = ?) AND (T2.SubTDescuLey = TRUE) AND (T1.ConHabilitado = TRUE) ORDER BY T1.CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

