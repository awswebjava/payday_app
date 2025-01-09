package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getagendavalorenrango extends GXProcedure
{
   public getagendavalorenrango( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getagendavalorenrango.class ), "" );
   }

   public getagendavalorenrango( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              String aP3 ,
                              java.util.Date aP4 ,
                              java.util.Date aP5 ,
                              short aP6 ,
                              boolean aP7 ,
                              java.math.BigDecimal[] aP8 ,
                              java.math.BigDecimal[] aP9 ,
                              java.math.BigDecimal[] aP10 )
   {
      getagendavalorenrango.this.aP11 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        java.util.Date aP4 ,
                        java.util.Date aP5 ,
                        short aP6 ,
                        boolean aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        java.math.BigDecimal[] aP10 ,
                        boolean[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             java.util.Date aP4 ,
                             java.util.Date aP5 ,
                             short aP6 ,
                             boolean aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             boolean[] aP11 )
   {
      getagendavalorenrango.this.AV11CliCod = aP0;
      getagendavalorenrango.this.AV12EmpCod = aP1;
      getagendavalorenrango.this.AV8LegNumero = aP2;
      getagendavalorenrango.this.AV13ConCodigo = aP3;
      getagendavalorenrango.this.AV9AgeFecHas = aP4;
      getagendavalorenrango.this.AV10AgeFecDes = aP5;
      getagendavalorenrango.this.AV18AgeOrden = aP6;
      getagendavalorenrango.this.AV19soloLibres = aP7;
      getagendavalorenrango.this.aP8 = aP8;
      getagendavalorenrango.this.aP9 = aP9;
      getagendavalorenrango.this.aP10 = aP10;
      getagendavalorenrango.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, "<= "+GXutil.trim( localUtil.dtoc( AV9AgeFecHas, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, ">= "+GXutil.trim( localUtil.dtoc( AV10AgeFecDes, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&AgeOrden ", "")+GXutil.trim( GXutil.str( AV18AgeOrden, 4, 0))+httpContext.getMessage( " &CliCod ", "")+GXutil.trim( GXutil.str( AV11CliCod, 6, 0))+httpContext.getMessage( " &EmpCod ", "")+GXutil.trim( GXutil.str( AV12EmpCod, 4, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV8LegNumero, 8, 0))+httpContext.getMessage( " &soloLibres ", "")+GXutil.trim( GXutil.booltostr( AV19soloLibres))+httpContext.getMessage( " &ConCodigo ", "")+AV13ConCodigo) ;
      AV23GXLvl6 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Boolean.valueOf(AV19soloLibres) ,
                                           Integer.valueOf(A1254AgeLiqNro) ,
                                           A112AgeFecHas ,
                                           AV10AgeFecDes ,
                                           Short.valueOf(A25AgeOrden) ,
                                           Short.valueOf(AV18AgeOrden) ,
                                           Integer.valueOf(AV11CliCod) ,
                                           Short.valueOf(AV12EmpCod) ,
                                           Integer.valueOf(AV8LegNumero) ,
                                           AV13ConCodigo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           A26ConCodigo ,
                                           A111AgeFecDes ,
                                           AV9AgeFecHas } ,
                                           new int[]{
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE
                                           }
      });
      /* Using cursor P01252 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV8LegNumero), AV13ConCodigo, AV10AgeFecDes, Short.valueOf(AV18AgeOrden), AV9AgeFecHas});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1254AgeLiqNro = P01252_A1254AgeLiqNro[0] ;
         n1254AgeLiqNro = P01252_n1254AgeLiqNro[0] ;
         A25AgeOrden = P01252_A25AgeOrden[0] ;
         A112AgeFecHas = P01252_A112AgeFecHas[0] ;
         n112AgeFecHas = P01252_n112AgeFecHas[0] ;
         A111AgeFecDes = P01252_A111AgeFecDes[0] ;
         n111AgeFecDes = P01252_n111AgeFecDes[0] ;
         A26ConCodigo = P01252_A26ConCodigo[0] ;
         A6LegNumero = P01252_A6LegNumero[0] ;
         A1EmpCod = P01252_A1EmpCod[0] ;
         A3CliCod = P01252_A3CliCod[0] ;
         A110AgeCanti = P01252_A110AgeCanti[0] ;
         n110AgeCanti = P01252_n110AgeCanti[0] ;
         A115AgeVUnit = P01252_A115AgeVUnit[0] ;
         n115AgeVUnit = P01252_n115AgeVUnit[0] ;
         A113AgeImporte = P01252_A113AgeImporte[0] ;
         n113AgeImporte = P01252_n113AgeImporte[0] ;
         AV23GXLvl6 = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, "5") ;
         AV14AgeCanti = A110AgeCanti ;
         AV15AgeVUnit = A115AgeVUnit ;
         AV16AgeImporte = A113AgeImporte ;
         AV17existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV23GXLvl6 == 0 )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = getagendavalorenrango.this.AV14AgeCanti;
      this.aP9[0] = getagendavalorenrango.this.AV15AgeVUnit;
      this.aP10[0] = getagendavalorenrango.this.AV16AgeImporte;
      this.aP11[0] = getagendavalorenrango.this.AV17existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14AgeCanti = DecimalUtil.ZERO ;
      AV15AgeVUnit = DecimalUtil.ZERO ;
      AV16AgeImporte = DecimalUtil.ZERO ;
      AV22Pgmname = "" ;
      scmdbuf = "" ;
      A112AgeFecHas = GXutil.nullDate() ;
      A26ConCodigo = "" ;
      A111AgeFecDes = GXutil.nullDate() ;
      P01252_A1254AgeLiqNro = new int[1] ;
      P01252_n1254AgeLiqNro = new boolean[] {false} ;
      P01252_A25AgeOrden = new short[1] ;
      P01252_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      P01252_n112AgeFecHas = new boolean[] {false} ;
      P01252_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      P01252_n111AgeFecDes = new boolean[] {false} ;
      P01252_A26ConCodigo = new String[] {""} ;
      P01252_A6LegNumero = new int[1] ;
      P01252_A1EmpCod = new short[1] ;
      P01252_A3CliCod = new int[1] ;
      P01252_A110AgeCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01252_n110AgeCanti = new boolean[] {false} ;
      P01252_A115AgeVUnit = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01252_n115AgeVUnit = new boolean[] {false} ;
      P01252_A113AgeImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01252_n113AgeImporte = new boolean[] {false} ;
      A110AgeCanti = DecimalUtil.ZERO ;
      A115AgeVUnit = DecimalUtil.ZERO ;
      A113AgeImporte = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getagendavalorenrango__default(),
         new Object[] {
             new Object[] {
            P01252_A1254AgeLiqNro, P01252_n1254AgeLiqNro, P01252_A25AgeOrden, P01252_A112AgeFecHas, P01252_n112AgeFecHas, P01252_A111AgeFecDes, P01252_n111AgeFecDes, P01252_A26ConCodigo, P01252_A6LegNumero, P01252_A1EmpCod,
            P01252_A3CliCod, P01252_A110AgeCanti, P01252_n110AgeCanti, P01252_A115AgeVUnit, P01252_n115AgeVUnit, P01252_A113AgeImporte, P01252_n113AgeImporte
            }
         }
      );
      AV22Pgmname = "GetAgendaValorEnRango" ;
      /* GeneXus formulas. */
      AV22Pgmname = "GetAgendaValorEnRango" ;
      Gx_err = (short)(0) ;
   }

   private byte AV23GXLvl6 ;
   private short AV12EmpCod ;
   private short AV18AgeOrden ;
   private short A25AgeOrden ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV8LegNumero ;
   private int A1254AgeLiqNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private java.math.BigDecimal AV14AgeCanti ;
   private java.math.BigDecimal AV15AgeVUnit ;
   private java.math.BigDecimal AV16AgeImporte ;
   private java.math.BigDecimal A110AgeCanti ;
   private java.math.BigDecimal A115AgeVUnit ;
   private java.math.BigDecimal A113AgeImporte ;
   private String AV13ConCodigo ;
   private String AV22Pgmname ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private java.util.Date AV9AgeFecHas ;
   private java.util.Date AV10AgeFecDes ;
   private java.util.Date A112AgeFecHas ;
   private java.util.Date A111AgeFecDes ;
   private boolean AV19soloLibres ;
   private boolean AV17existe ;
   private boolean n1254AgeLiqNro ;
   private boolean n112AgeFecHas ;
   private boolean n111AgeFecDes ;
   private boolean n110AgeCanti ;
   private boolean n115AgeVUnit ;
   private boolean n113AgeImporte ;
   private boolean Cond_result ;
   private boolean[] aP11 ;
   private java.math.BigDecimal[] aP8 ;
   private java.math.BigDecimal[] aP9 ;
   private java.math.BigDecimal[] aP10 ;
   private IDataStoreProvider pr_default ;
   private int[] P01252_A1254AgeLiqNro ;
   private boolean[] P01252_n1254AgeLiqNro ;
   private short[] P01252_A25AgeOrden ;
   private java.util.Date[] P01252_A112AgeFecHas ;
   private boolean[] P01252_n112AgeFecHas ;
   private java.util.Date[] P01252_A111AgeFecDes ;
   private boolean[] P01252_n111AgeFecDes ;
   private String[] P01252_A26ConCodigo ;
   private int[] P01252_A6LegNumero ;
   private short[] P01252_A1EmpCod ;
   private int[] P01252_A3CliCod ;
   private java.math.BigDecimal[] P01252_A110AgeCanti ;
   private boolean[] P01252_n110AgeCanti ;
   private java.math.BigDecimal[] P01252_A115AgeVUnit ;
   private boolean[] P01252_n115AgeVUnit ;
   private java.math.BigDecimal[] P01252_A113AgeImporte ;
   private boolean[] P01252_n113AgeImporte ;
}

final  class getagendavalorenrango__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01252( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          boolean AV19soloLibres ,
                                          int A1254AgeLiqNro ,
                                          java.util.Date A112AgeFecHas ,
                                          java.util.Date AV10AgeFecDes ,
                                          short A25AgeOrden ,
                                          short AV18AgeOrden ,
                                          int AV11CliCod ,
                                          short AV12EmpCod ,
                                          int AV8LegNumero ,
                                          String AV13ConCodigo ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero ,
                                          String A26ConCodigo ,
                                          java.util.Date A111AgeFecDes ,
                                          java.util.Date AV9AgeFecHas )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[7];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT AgeLiqNro, AgeOrden, AgeFecHas, AgeFecDes, ConCodigo, LegNumero, EmpCod, CliCod, AgeCanti, AgeVUnit, AgeImporte FROM AgendaNovedades" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ? and ConCodigo = ( ?))");
      addWhere(sWhereString, "(AgeFecHas >= ? or (AgeFecHas = DATE '00010101') or AgeFecHas IS NULL)");
      addWhere(sWhereString, "(AgeOrden <> ?)");
      addWhere(sWhereString, "(AgeFecDes <= ?)");
      if ( AV19soloLibres )
      {
         addWhere(sWhereString, "(AgeLiqNro IS NULL)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LegNumero, ConCodigo" ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
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
                  return conditional_P01252(context, remoteHandle, httpContext, ((Boolean) dynConstraints[0]).booleanValue() , ((Number) dynConstraints[1]).intValue() , (java.util.Date)dynConstraints[2] , (java.util.Date)dynConstraints[3] , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (java.util.Date)dynConstraints[14] , (java.util.Date)dynConstraints[15] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01252", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getString(5, 10);
               ((int[]) buf[8])[0] = rslt.getInt(6);
               ((short[]) buf[9])[0] = rslt.getShort(7);
               ((int[]) buf[10])[0] = rslt.getInt(8);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(9,2);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(11,2);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
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
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 10);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[11]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               return;
      }
   }

}

