package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class deletecclicenciastodas extends GXProcedure
{
   public deletecclicenciastodas( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( deletecclicenciastodas.class ), "" );
   }

   public deletecclicenciastodas( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        short aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             short aP4 )
   {
      deletecclicenciastodas.this.AV10CliCod = aP0;
      deletecclicenciastodas.this.AV11EmpCod = aP1;
      deletecclicenciastodas.this.AV8LegNumero = aP2;
      deletecclicenciastodas.this.AV9LegCuenLicTpo = aP3;
      deletecclicenciastodas.this.AV12LegCuenAnio = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV17Pgmname, "1") ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV8LegNumero) ,
                                           Short.valueOf(AV12LegCuenAnio) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           Short.valueOf(A2266LegCuenAnio) ,
                                           A2243LegCuenLicTpo ,
                                           AV9LegCuenLicTpo ,
                                           Integer.valueOf(AV10CliCod) ,
                                           Short.valueOf(AV11EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P02C92 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), AV9LegCuenLicTpo, Integer.valueOf(AV8LegNumero), Short.valueOf(AV12LegCuenAnio)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2266LegCuenAnio = P02C92_A2266LegCuenAnio[0] ;
         A2243LegCuenLicTpo = P02C92_A2243LegCuenLicTpo[0] ;
         A6LegNumero = P02C92_A6LegNumero[0] ;
         A1EmpCod = P02C92_A1EmpCod[0] ;
         A3CliCod = P02C92_A3CliCod[0] ;
         A2299LegCuenAntAnios = P02C92_A2299LegCuenAntAnios[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV17Pgmname, "2") ;
         /* Using cursor P02C93 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A2312LegCuLConsCnt = P02C93_A2312LegCuLConsCnt[0] ;
            A2310LegCuLConsAnio = P02C93_A2310LegCuLConsAnio[0] ;
            A2311LegCuLConsSec = P02C93_A2311LegCuLConsSec[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV17Pgmname, "3") ;
            /* Using cursor P02C94 */
            pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), Short.valueOf(A2310LegCuLConsAnio), Short.valueOf(A2311LegCuLConsSec)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licenciasconsumos");
            pr_default.readNext(1);
         }
         pr_default.close(1);
         /* Using cursor P02C95 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio)});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A2325LegCuLAprLicCnt = P02C95_A2325LegCuLAprLicCnt[0] ;
            A2324LegCuLAprLicFch = P02C95_A2324LegCuLAprLicFch[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV17Pgmname, "4") ;
            /* Using cursor P02C96 */
            pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio), A2324LegCuLAprLicFch});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licenciasaprobaciones");
            pr_default.readNext(3);
         }
         pr_default.close(3);
         new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV17Pgmname, "5") ;
         /* Using cursor P02C97 */
         pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2243LegCuenLicTpo, Short.valueOf(A2266LegCuenAnio)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_cuenta_licencias");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV17Pgmname, httpContext.getMessage( "fin", "")) ;
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "deletecclicenciastodas");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17Pgmname = "" ;
      scmdbuf = "" ;
      A2243LegCuenLicTpo = "" ;
      P02C92_A2266LegCuenAnio = new short[1] ;
      P02C92_A2243LegCuenLicTpo = new String[] {""} ;
      P02C92_A6LegNumero = new int[1] ;
      P02C92_A1EmpCod = new short[1] ;
      P02C92_A3CliCod = new int[1] ;
      P02C92_A2299LegCuenAntAnios = new short[1] ;
      P02C93_A3CliCod = new int[1] ;
      P02C93_A1EmpCod = new short[1] ;
      P02C93_A6LegNumero = new int[1] ;
      P02C93_A2243LegCuenLicTpo = new String[] {""} ;
      P02C93_A2266LegCuenAnio = new short[1] ;
      P02C93_A2312LegCuLConsCnt = new short[1] ;
      P02C93_A2310LegCuLConsAnio = new short[1] ;
      P02C93_A2311LegCuLConsSec = new short[1] ;
      P02C95_A3CliCod = new int[1] ;
      P02C95_A1EmpCod = new short[1] ;
      P02C95_A6LegNumero = new int[1] ;
      P02C95_A2243LegCuenLicTpo = new String[] {""} ;
      P02C95_A2266LegCuenAnio = new short[1] ;
      P02C95_A2325LegCuLAprLicCnt = new short[1] ;
      P02C95_A2324LegCuLAprLicFch = new java.util.Date[] {GXutil.nullDate()} ;
      A2324LegCuLAprLicFch = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.deletecclicenciastodas__default(),
         new Object[] {
             new Object[] {
            P02C92_A2266LegCuenAnio, P02C92_A2243LegCuenLicTpo, P02C92_A6LegNumero, P02C92_A1EmpCod, P02C92_A3CliCod, P02C92_A2299LegCuenAntAnios
            }
            , new Object[] {
            P02C93_A3CliCod, P02C93_A1EmpCod, P02C93_A6LegNumero, P02C93_A2243LegCuenLicTpo, P02C93_A2266LegCuenAnio, P02C93_A2312LegCuLConsCnt, P02C93_A2310LegCuLConsAnio, P02C93_A2311LegCuLConsSec
            }
            , new Object[] {
            }
            , new Object[] {
            P02C95_A3CliCod, P02C95_A1EmpCod, P02C95_A6LegNumero, P02C95_A2243LegCuenLicTpo, P02C95_A2266LegCuenAnio, P02C95_A2325LegCuLAprLicCnt, P02C95_A2324LegCuLAprLicFch
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV17Pgmname = "deleteCCLicenciasTodas" ;
      /* GeneXus formulas. */
      AV17Pgmname = "deleteCCLicenciasTodas" ;
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV12LegCuenAnio ;
   private short A2266LegCuenAnio ;
   private short A1EmpCod ;
   private short A2299LegCuenAntAnios ;
   private short A2312LegCuLConsCnt ;
   private short A2310LegCuLConsAnio ;
   private short A2311LegCuLConsSec ;
   private short A2325LegCuLAprLicCnt ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV9LegCuenLicTpo ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private String A2243LegCuenLicTpo ;
   private java.util.Date A2324LegCuLAprLicFch ;
   private IDataStoreProvider pr_default ;
   private short[] P02C92_A2266LegCuenAnio ;
   private String[] P02C92_A2243LegCuenLicTpo ;
   private int[] P02C92_A6LegNumero ;
   private short[] P02C92_A1EmpCod ;
   private int[] P02C92_A3CliCod ;
   private short[] P02C92_A2299LegCuenAntAnios ;
   private int[] P02C93_A3CliCod ;
   private short[] P02C93_A1EmpCod ;
   private int[] P02C93_A6LegNumero ;
   private String[] P02C93_A2243LegCuenLicTpo ;
   private short[] P02C93_A2266LegCuenAnio ;
   private short[] P02C93_A2312LegCuLConsCnt ;
   private short[] P02C93_A2310LegCuLConsAnio ;
   private short[] P02C93_A2311LegCuLConsSec ;
   private int[] P02C95_A3CliCod ;
   private short[] P02C95_A1EmpCod ;
   private int[] P02C95_A6LegNumero ;
   private String[] P02C95_A2243LegCuenLicTpo ;
   private short[] P02C95_A2266LegCuenAnio ;
   private short[] P02C95_A2325LegCuLAprLicCnt ;
   private java.util.Date[] P02C95_A2324LegCuLAprLicFch ;
}

final  class deletecclicenciastodas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02C92( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV8LegNumero ,
                                          short AV12LegCuenAnio ,
                                          int A6LegNumero ,
                                          short A2266LegCuenAnio ,
                                          String A2243LegCuenLicTpo ,
                                          String AV9LegCuenLicTpo ,
                                          int AV10CliCod ,
                                          short AV11EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[5];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT LegCuenAnio, LegCuenLicTpo, LegNumero, EmpCod, CliCod, LegCuenAntAnios FROM legajo_cuenta_licencias" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      addWhere(sWhereString, "(LegCuenLicTpo = ( ?))");
      if ( ! (0==AV8LegNumero) )
      {
         addWhere(sWhereString, "(LegNumero = ?)");
      }
      else
      {
         GXv_int1[3] = (byte)(1) ;
      }
      if ( ! (0==AV12LegCuenAnio) )
      {
         addWhere(sWhereString, "(LegCuenAnio = ?)");
      }
      else
      {
         GXv_int1[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      scmdbuf += " FOR UPDATE OF legajo_cuenta_licencias" ;
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
                  return conditional_P02C92(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , (String)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02C92", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02C93", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLConsCnt, LegCuLConsAnio, LegCuLConsSec FROM legajo_cuenta_licenciasconsumos WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ? ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio  FOR UPDATE OF legajo_cuenta_licenciasconsumos",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P02C94", "SAVEPOINT gxupdate;DELETE FROM legajo_cuenta_licenciasconsumos  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ? AND LegCuLConsAnio = ? AND LegCuLConsSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P02C95", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLAprLicCnt, LegCuLAprLicFch FROM legajo_cuenta_licenciasaprobaciones WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ? ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio  FOR UPDATE OF legajo_cuenta_licenciasaprobaciones",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P02C96", "SAVEPOINT gxupdate;DELETE FROM legajo_cuenta_licenciasaprobaciones  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ? AND LegCuLAprLicFch = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P02C97", "SAVEPOINT gxupdate;DELETE FROM legajo_cuenta_licencias  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegCuenLicTpo = ? AND LegCuenAnio = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
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
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
      }
   }

}

