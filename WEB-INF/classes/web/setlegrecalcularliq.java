package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setlegrecalcularliq extends GXProcedure
{
   public setlegrecalcularliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setlegrecalcularliq.class ), "" );
   }

   public setlegrecalcularliq( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        boolean aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             boolean aP3 )
   {
      setlegrecalcularliq.this.AV10CliCod = aP0;
      setlegrecalcularliq.this.AV9EmpCod = aP1;
      setlegrecalcularliq.this.AV8LegNumero = aP2;
      setlegrecalcularliq.this.AV11LegRecalcLiq = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Short.valueOf(AV9EmpCod) ,
                                           Integer.valueOf(AV8LegNumero) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           Integer.valueOf(AV10CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P011O2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P011O2_A6LegNumero[0] ;
         A1EmpCod = P011O2_A1EmpCod[0] ;
         A3CliCod = P011O2_A3CliCod[0] ;
         A942LegRecalcLiq = P011O2_A942LegRecalcLiq[0] ;
         A942LegRecalcLiq = AV11LegRecalcLiq ;
         /* Using cursor P011O3 */
         pr_default.execute(1, new Object[] {Boolean.valueOf(A942LegRecalcLiq), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P011O2_A6LegNumero = new int[1] ;
      P011O2_A1EmpCod = new short[1] ;
      P011O2_A3CliCod = new int[1] ;
      P011O2_A942LegRecalcLiq = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.setlegrecalcularliq__default(),
         new Object[] {
             new Object[] {
            P011O2_A6LegNumero, P011O2_A1EmpCod, P011O2_A3CliCod, P011O2_A942LegRecalcLiq
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean AV11LegRecalcLiq ;
   private boolean A942LegRecalcLiq ;
   private IDataStoreProvider pr_default ;
   private int[] P011O2_A6LegNumero ;
   private short[] P011O2_A1EmpCod ;
   private int[] P011O2_A3CliCod ;
   private boolean[] P011O2_A942LegRecalcLiq ;
}

final  class setlegrecalcularliq__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P011O2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV9EmpCod ,
                                          int AV8LegNumero ,
                                          short A1EmpCod ,
                                          int A6LegNumero ,
                                          int AV10CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[3];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT LegNumero, EmpCod, CliCod, LegRecalcLiq FROM Legajo" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV9EmpCod) )
      {
         addWhere(sWhereString, "(EmpCod = ?)");
      }
      else
      {
         GXv_int1[1] = (byte)(1) ;
      }
      if ( ! (0==AV8LegNumero) )
      {
         addWhere(sWhereString, "(LegNumero = ?)");
      }
      else
      {
         GXv_int1[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      scmdbuf += " FOR UPDATE OF Legajo" ;
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
                  return conditional_P011O2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P011O2", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P011O3", "SAVEPOINT gxupdate;UPDATE Legajo SET LegRecalcLiq=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
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
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               return;
            case 1 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

