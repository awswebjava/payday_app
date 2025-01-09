package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class eliminarnovedadconcepto extends GXProcedure
{
   public eliminarnovedadconcepto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( eliminarnovedadconcepto.class ), "" );
   }

   public eliminarnovedadconcepto( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 )
   {
      eliminarnovedadconcepto.this.AV9CliCod = aP0;
      eliminarnovedadconcepto.this.AV10EmpCod = aP1;
      eliminarnovedadconcepto.this.AV11LegNumero = aP2;
      eliminarnovedadconcepto.this.AV12AgeOrden = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV11LegNumero) ,
                                           Short.valueOf(AV12AgeOrden) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           Short.valueOf(A25AgeOrden) ,
                                           Integer.valueOf(AV9CliCod) ,
                                           Short.valueOf(AV10EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P01622 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV11LegNumero), Short.valueOf(AV12AgeOrden)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A25AgeOrden = P01622_A25AgeOrden[0] ;
         A6LegNumero = P01622_A6LegNumero[0] ;
         A1EmpCod = P01622_A1EmpCod[0] ;
         A3CliCod = P01622_A3CliCod[0] ;
         /* Using cursor P01623 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A25AgeOrden)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("AgendaNovedades");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "eliminarnovedadconcepto");
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
      P01622_A25AgeOrden = new short[1] ;
      P01622_A6LegNumero = new int[1] ;
      P01622_A1EmpCod = new short[1] ;
      P01622_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.eliminarnovedadconcepto__default(),
         new Object[] {
             new Object[] {
            P01622_A25AgeOrden, P01622_A6LegNumero, P01622_A1EmpCod, P01622_A3CliCod
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short AV12AgeOrden ;
   private short A25AgeOrden ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV11LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private IDataStoreProvider pr_default ;
   private short[] P01622_A25AgeOrden ;
   private int[] P01622_A6LegNumero ;
   private short[] P01622_A1EmpCod ;
   private int[] P01622_A3CliCod ;
}

final  class eliminarnovedadconcepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01622( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV11LegNumero ,
                                          short AV12AgeOrden ,
                                          int A6LegNumero ,
                                          short A25AgeOrden ,
                                          int AV9CliCod ,
                                          short AV10EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[4];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT AgeOrden, LegNumero, EmpCod, CliCod FROM AgendaNovedades" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV11LegNumero) )
      {
         addWhere(sWhereString, "(LegNumero = ?)");
      }
      else
      {
         GXv_int1[2] = (byte)(1) ;
      }
      if ( ! (0==AV12AgeOrden) )
      {
         addWhere(sWhereString, "(AgeOrden = ?)");
      }
      else
      {
         GXv_int1[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      scmdbuf += " FOR UPDATE OF AgendaNovedades" ;
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
                  return conditional_P01622(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01622", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01623", "SAVEPOINT gxupdate;DELETE FROM AgendaNovedades  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND AgeOrden = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
      }
   }

}

