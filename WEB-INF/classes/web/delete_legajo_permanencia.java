package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class delete_legajo_permanencia extends GXProcedure
{
   public delete_legajo_permanencia( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( delete_legajo_permanencia.class ), "" );
   }

   public delete_legajo_permanencia( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 )
   {
      delete_legajo_permanencia.this.AV14CliCod = aP0;
      delete_legajo_permanencia.this.AV13EmpCod = aP1;
      delete_legajo_permanencia.this.AV12LegNumero = aP2;
      delete_legajo_permanencia.this.AV11LegHisFecIng = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV12LegNumero) ,
                                           AV11LegHisFecIng ,
                                           Integer.valueOf(A6LegNumero) ,
                                           A2253LegHisFecIng ,
                                           Integer.valueOf(AV14CliCod) ,
                                           Short.valueOf(AV13EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.DATE, TypeConstants.INT, TypeConstants.DATE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P02CC2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV14CliCod), Short.valueOf(AV13EmpCod), Integer.valueOf(AV12LegNumero), AV11LegHisFecIng});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2253LegHisFecIng = P02CC2_A2253LegHisFecIng[0] ;
         A6LegNumero = P02CC2_A6LegNumero[0] ;
         A1EmpCod = P02CC2_A1EmpCod[0] ;
         A3CliCod = P02CC2_A3CliCod[0] ;
         /* Using cursor P02CC3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A2253LegHisFecIng});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_permanencia");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "delete_legajo_permanencia");
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
      A2253LegHisFecIng = GXutil.nullDate() ;
      P02CC2_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      P02CC2_A6LegNumero = new int[1] ;
      P02CC2_A1EmpCod = new short[1] ;
      P02CC2_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.delete_legajo_permanencia__default(),
         new Object[] {
             new Object[] {
            P02CC2_A2253LegHisFecIng, P02CC2_A6LegNumero, P02CC2_A1EmpCod, P02CC2_A3CliCod
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV13EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int AV12LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private java.util.Date AV11LegHisFecIng ;
   private java.util.Date A2253LegHisFecIng ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P02CC2_A2253LegHisFecIng ;
   private int[] P02CC2_A6LegNumero ;
   private short[] P02CC2_A1EmpCod ;
   private int[] P02CC2_A3CliCod ;
}

final  class delete_legajo_permanencia__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02CC2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV12LegNumero ,
                                          java.util.Date AV11LegHisFecIng ,
                                          int A6LegNumero ,
                                          java.util.Date A2253LegHisFecIng ,
                                          int AV14CliCod ,
                                          short AV13EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[4];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT LegHisFecIng, LegNumero, EmpCod, CliCod FROM legajo_permanencia" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV12LegNumero) )
      {
         addWhere(sWhereString, "(LegNumero = ?)");
      }
      else
      {
         GXv_int1[2] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV11LegHisFecIng)) )
      {
         addWhere(sWhereString, "(LegHisFecIng = ?)");
      }
      else
      {
         GXv_int1[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      scmdbuf += " FOR UPDATE OF legajo_permanencia" ;
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
                  return conditional_P02CC2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , (java.util.Date)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (java.util.Date)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02CC2", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P02CC3", "SAVEPOINT gxupdate;DELETE FROM legajo_permanencia  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegHisFecIng = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
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
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[7]);
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
      }
   }

}

