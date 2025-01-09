package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getdiaslicenciaperiodo extends GXProcedure
{
   public getdiaslicenciaperiodo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getdiaslicenciaperiodo.class ), "" );
   }

   public getdiaslicenciaperiodo( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     int aP2 ,
                                     String aP3 ,
                                     int aP4 ,
                                     java.util.Date aP5 ,
                                     boolean aP6 ,
                                     boolean aP7 ,
                                     String aP8 ,
                                     boolean aP9 ,
                                     boolean aP10 ,
                                     short[] aP11 ,
                                     java.util.Date[] aP12 )
   {
      getdiaslicenciaperiodo.this.aP13 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
      return aP13[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        boolean aP6 ,
                        boolean aP7 ,
                        String aP8 ,
                        boolean aP9 ,
                        boolean aP10 ,
                        short[] aP11 ,
                        java.util.Date[] aP12 ,
                        java.util.Date[] aP13 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             boolean aP6 ,
                             boolean aP7 ,
                             String aP8 ,
                             boolean aP9 ,
                             boolean aP10 ,
                             short[] aP11 ,
                             java.util.Date[] aP12 ,
                             java.util.Date[] aP13 )
   {
      getdiaslicenciaperiodo.this.AV8CliCod = aP0;
      getdiaslicenciaperiodo.this.AV9EmpCod = aP1;
      getdiaslicenciaperiodo.this.AV32LiqNro = aP2;
      getdiaslicenciaperiodo.this.AV33parmTLiqCod = aP3;
      getdiaslicenciaperiodo.this.AV10LegNumero = aP4;
      getdiaslicenciaperiodo.this.AV12liqPeriodo = aP5;
      getdiaslicenciaperiodo.this.AV19semestralEs = aP6;
      getdiaslicenciaperiodo.this.AV20futuroEs = aP7;
      getdiaslicenciaperiodo.this.AV14devolver = aP8;
      getdiaslicenciaperiodo.this.AV23vacacionesEs = aP9;
      getdiaslicenciaperiodo.this.AV24todoElAnio = aP10;
      getdiaslicenciaperiodo.this.aP11 = aP11;
      getdiaslicenciaperiodo.this.aP12 = aP12;
      getdiaslicenciaperiodo.this.aP13 = aP13;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV37tipo_tarifa ;
      new web.gettipodetarifa(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV32LiqNro, AV10LegNumero, (short)(0), "", "", GXv_char1) ;
      getdiaslicenciaperiodo.this.AV37tipo_tarifa = GXv_char1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( "futuro es ", "")+GXutil.trim( GXutil.booltostr( AV20futuroEs))) ;
      if ( ! AV20futuroEs )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( "semestrales ", "")+GXutil.trim( GXutil.booltostr( AV19semestralEs))) ;
         if ( AV19semestralEs )
         {
            if ( GXutil.month( AV12liqPeriodo) <= 6 )
            {
               AV11inicio_periodo = localUtil.ymdtod( GXutil.year( AV12liqPeriodo), 1, 1) ;
               AV13fin_periodo = localUtil.ymdtod( GXutil.year( AV12liqPeriodo), 6, 30) ;
            }
            else
            {
               AV11inicio_periodo = localUtil.ymdtod( GXutil.year( AV12liqPeriodo), 7, 1) ;
               AV13fin_periodo = localUtil.ymdtod( GXutil.year( AV12liqPeriodo), 12, 31) ;
            }
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( "todoelaño ", "")+GXutil.trim( GXutil.booltostr( AV24todoElAnio))) ;
            GXv_date2[0] = AV11inicio_periodo ;
            GXv_date3[0] = AV13fin_periodo ;
            new web.getliqperdesyhas(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV32LiqNro, GXv_date2, GXv_date3) ;
            getdiaslicenciaperiodo.this.AV11inicio_periodo = GXv_date2[0] ;
            getdiaslicenciaperiodo.this.AV13fin_periodo = GXv_date3[0] ;
         }
      }
      else
      {
         GXv_char1[0] = "" ;
         GXv_date3[0] = AV21LegFecEgreso ;
         new web.empleadogetegreso(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, GXv_char1, GXv_date3) ;
         getdiaslicenciaperiodo.this.AV21LegFecEgreso = GXv_date3[0] ;
         if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV21LegFecEgreso)) )
         {
            AV11inicio_periodo = AV21LegFecEgreso ;
         }
         else
         {
            AV11inicio_periodo = GXutil.addmth( AV12liqPeriodo, (short)(1)) ;
            AV11inicio_periodo = localUtil.ymdtod( GXutil.year( AV11inicio_periodo), GXutil.month( AV11inicio_periodo), 1) ;
         }
         AV13fin_periodo = localUtil.ymdtod( GXutil.year( AV12liqPeriodo), 12, 31) ;
      }
      GXt_char4 = AV22vacaciones_SitCodigo ;
      GXv_char1[0] = GXt_char4 ;
      new web.codigodesituacionvacaciones(remoteHandle, context).execute( AV8CliCod, GXv_char1) ;
      getdiaslicenciaperiodo.this.GXt_char4 = GXv_char1[0] ;
      AV22vacaciones_SitCodigo = GXt_char4 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( "ini ", "")+GXutil.trim( localUtil.dtoc( AV11inicio_periodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " fin ", "")+GXutil.trim( localUtil.dtoc( AV13fin_periodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Boolean.valueOf(AV23vacacionesEs) ,
                                           A506LegLicSitCodigo ,
                                           AV22vacaciones_SitCodigo ,
                                           A481LegLicenFin ,
                                           AV11inicio_periodo ,
                                           A1497LegLicEstado ,
                                           Integer.valueOf(AV8CliCod) ,
                                           Short.valueOf(AV9EmpCod) ,
                                           Integer.valueOf(AV10LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           A76LegLicenIni ,
                                           AV13fin_periodo } ,
                                           new int[]{
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      /* Using cursor P00Q72 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), AV11inicio_periodo, AV13fin_periodo, AV22vacaciones_SitCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1497LegLicEstado = P00Q72_A1497LegLicEstado[0] ;
         A506LegLicSitCodigo = P00Q72_A506LegLicSitCodigo[0] ;
         A481LegLicenFin = P00Q72_A481LegLicenFin[0] ;
         A76LegLicenIni = P00Q72_A76LegLicenIni[0] ;
         A6LegNumero = P00Q72_A6LegNumero[0] ;
         A1EmpCod = P00Q72_A1EmpCod[0] ;
         A3CliCod = P00Q72_A3CliCod[0] ;
         if ( AV23vacacionesEs )
         {
            AV18SitEsLicencia = true ;
            AV25SitEsAusencia = false ;
            AV17SitLicCuentaTrab = true ;
         }
         else
         {
            GXv_boolean5[0] = AV18SitEsLicencia ;
            GXv_boolean6[0] = AV25SitEsAusencia ;
            GXv_boolean7[0] = AV17SitLicCuentaTrab ;
            GXv_boolean8[0] = false ;
            GXv_boolean9[0] = false ;
            GXv_boolean10[0] = false ;
            GXv_boolean11[0] = AV35EstadoRemCorr ;
            new web.getsituacionlicenciaprops(remoteHandle, context).execute( A506LegLicSitCodigo, GXv_boolean5, GXv_boolean6, GXv_boolean7, GXv_boolean8, GXv_boolean9, GXv_boolean10, GXv_boolean11) ;
            getdiaslicenciaperiodo.this.AV18SitEsLicencia = GXv_boolean5[0] ;
            getdiaslicenciaperiodo.this.AV25SitEsAusencia = GXv_boolean6[0] ;
            getdiaslicenciaperiodo.this.AV17SitLicCuentaTrab = GXv_boolean7[0] ;
            getdiaslicenciaperiodo.this.AV35EstadoRemCorr = GXv_boolean11[0] ;
         }
         if ( ( AV18SitEsLicencia ) || ( AV25SitEsAusencia ) )
         {
            GXv_int12[0] = AV16dias ;
            GXv_date3[0] = AV26out_inicio_periodo ;
            GXv_date2[0] = AV27out_fin_periodo ;
            new web.calculadias(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, AV37tipo_tarifa, AV35EstadoRemCorr, A76LegLicenIni, A481LegLicenFin, AV11inicio_periodo, AV13fin_periodo, GXv_int12, GXv_date3, GXv_date2) ;
            getdiaslicenciaperiodo.this.AV16dias = GXv_int12[0] ;
            getdiaslicenciaperiodo.this.AV26out_inicio_periodo = GXv_date3[0] ;
            getdiaslicenciaperiodo.this.AV27out_fin_periodo = GXv_date2[0] ;
            if ( GXutil.strcmp(AV14devolver, httpContext.getMessage( "CUENTAN COMO TRABAJADOS", "")) == 0 )
            {
               if ( AV17SitLicCuentaTrab )
               {
                  AV15CANTIDAD = (short)(AV15CANTIDAD+AV16dias) ;
               }
            }
            else if ( GXutil.strcmp(AV14devolver, httpContext.getMessage( "CUENTAN COMO NO TRABAJADOS", "")) == 0 )
            {
               if ( ! AV17SitLicCuentaTrab )
               {
                  AV15CANTIDAD = (short)(AV15CANTIDAD+AV16dias) ;
               }
            }
            else
            {
               AV15CANTIDAD = (short)(AV15CANTIDAD+AV16dias) ;
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP11[0] = getdiaslicenciaperiodo.this.AV15CANTIDAD;
      this.aP12[0] = getdiaslicenciaperiodo.this.AV26out_inicio_periodo;
      this.aP13[0] = getdiaslicenciaperiodo.this.AV27out_fin_periodo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV26out_inicio_periodo = GXutil.nullDate() ;
      AV27out_fin_periodo = GXutil.nullDate() ;
      AV37tipo_tarifa = "" ;
      AV41Pgmname = "" ;
      AV11inicio_periodo = GXutil.nullDate() ;
      AV13fin_periodo = GXutil.nullDate() ;
      AV21LegFecEgreso = GXutil.nullDate() ;
      AV22vacaciones_SitCodigo = "" ;
      GXt_char4 = "" ;
      GXv_char1 = new String[1] ;
      scmdbuf = "" ;
      A506LegLicSitCodigo = "" ;
      A481LegLicenFin = GXutil.nullDate() ;
      A1497LegLicEstado = "" ;
      A76LegLicenIni = GXutil.nullDate() ;
      P00Q72_A1497LegLicEstado = new String[] {""} ;
      P00Q72_A506LegLicSitCodigo = new String[] {""} ;
      P00Q72_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      P00Q72_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      P00Q72_A6LegNumero = new int[1] ;
      P00Q72_A1EmpCod = new short[1] ;
      P00Q72_A3CliCod = new int[1] ;
      GXv_boolean5 = new boolean[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXv_boolean7 = new boolean[1] ;
      GXv_boolean8 = new boolean[1] ;
      GXv_boolean9 = new boolean[1] ;
      GXv_boolean10 = new boolean[1] ;
      GXv_boolean11 = new boolean[1] ;
      GXv_int12 = new short[1] ;
      GXv_date3 = new java.util.Date[1] ;
      GXv_date2 = new java.util.Date[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getdiaslicenciaperiodo__default(),
         new Object[] {
             new Object[] {
            P00Q72_A1497LegLicEstado, P00Q72_A506LegLicSitCodigo, P00Q72_A481LegLicenFin, P00Q72_A76LegLicenIni, P00Q72_A6LegNumero, P00Q72_A1EmpCod, P00Q72_A3CliCod
            }
         }
      );
      AV41Pgmname = "getDiasLicenciaPeriodo" ;
      /* GeneXus formulas. */
      AV41Pgmname = "getDiasLicenciaPeriodo" ;
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV15CANTIDAD ;
   private short A1EmpCod ;
   private short AV16dias ;
   private short GXv_int12[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV32LiqNro ;
   private int AV10LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String AV33parmTLiqCod ;
   private String AV14devolver ;
   private String AV37tipo_tarifa ;
   private String AV41Pgmname ;
   private String AV22vacaciones_SitCodigo ;
   private String GXt_char4 ;
   private String GXv_char1[] ;
   private String scmdbuf ;
   private String A506LegLicSitCodigo ;
   private String A1497LegLicEstado ;
   private java.util.Date AV12liqPeriodo ;
   private java.util.Date AV26out_inicio_periodo ;
   private java.util.Date AV27out_fin_periodo ;
   private java.util.Date AV11inicio_periodo ;
   private java.util.Date AV13fin_periodo ;
   private java.util.Date AV21LegFecEgreso ;
   private java.util.Date A481LegLicenFin ;
   private java.util.Date A76LegLicenIni ;
   private java.util.Date GXv_date3[] ;
   private java.util.Date GXv_date2[] ;
   private boolean AV19semestralEs ;
   private boolean AV20futuroEs ;
   private boolean AV23vacacionesEs ;
   private boolean AV24todoElAnio ;
   private boolean AV18SitEsLicencia ;
   private boolean AV25SitEsAusencia ;
   private boolean AV17SitLicCuentaTrab ;
   private boolean GXv_boolean5[] ;
   private boolean GXv_boolean6[] ;
   private boolean GXv_boolean7[] ;
   private boolean GXv_boolean8[] ;
   private boolean GXv_boolean9[] ;
   private boolean GXv_boolean10[] ;
   private boolean AV35EstadoRemCorr ;
   private boolean GXv_boolean11[] ;
   private java.util.Date[] aP13 ;
   private short[] aP11 ;
   private java.util.Date[] aP12 ;
   private IDataStoreProvider pr_default ;
   private String[] P00Q72_A1497LegLicEstado ;
   private String[] P00Q72_A506LegLicSitCodigo ;
   private java.util.Date[] P00Q72_A481LegLicenFin ;
   private java.util.Date[] P00Q72_A76LegLicenIni ;
   private int[] P00Q72_A6LegNumero ;
   private short[] P00Q72_A1EmpCod ;
   private int[] P00Q72_A3CliCod ;
}

final  class getdiaslicenciaperiodo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00Q72( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          boolean AV23vacacionesEs ,
                                          String A506LegLicSitCodigo ,
                                          String AV22vacaciones_SitCodigo ,
                                          java.util.Date A481LegLicenFin ,
                                          java.util.Date AV11inicio_periodo ,
                                          String A1497LegLicEstado ,
                                          int AV8CliCod ,
                                          short AV9EmpCod ,
                                          int AV10LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero ,
                                          java.util.Date A76LegLicenIni ,
                                          java.util.Date AV13fin_periodo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[6];
      Object[] GXv_Object14 = new Object[2];
      scmdbuf = "SELECT LegLicEstado, LegLicSitCodigo, LegLicenFin, LegLicenIni, LegNumero, EmpCod, CliCod FROM LegajoLicencias" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ?)");
      addWhere(sWhereString, "(LegLicenFin >= ?)");
      addWhere(sWhereString, "(LegLicEstado = ( 'autorizada'))");
      addWhere(sWhereString, "(LegLicenIni <= ?)");
      if ( AV23vacacionesEs )
      {
         addWhere(sWhereString, "(LegLicSitCodigo = ( ?))");
      }
      else
      {
         GXv_int13[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LegNumero" ;
      GXv_Object14[0] = scmdbuf ;
      GXv_Object14[1] = GXv_int13 ;
      return GXv_Object14 ;
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
                  return conditional_P00Q72(context, remoteHandle, httpContext, ((Boolean) dynConstraints[0]).booleanValue() , (String)dynConstraints[1] , (String)dynConstraints[2] , (java.util.Date)dynConstraints[3] , (java.util.Date)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).intValue() , (java.util.Date)dynConstraints[12] , (java.util.Date)dynConstraints[13] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00Q72", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
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
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[9]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[10]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 4);
               }
               return;
      }
   }

}

