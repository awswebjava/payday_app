package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class deletededucciones extends GXProcedure
{
   public deletededucciones( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( deletededucciones.class ), "" );
   }

   public deletededucciones( int remoteHandle ,
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
      deletededucciones.this.AV8CliCod = aP0;
      deletededucciones.this.AV9EmpCod = aP1;
      deletededucciones.this.AV10LegNumero = aP2;
      deletededucciones.this.AV11LegDedAnio = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV10LegNumero) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           Short.valueOf(A768LegDedAnio) ,
                                           Short.valueOf(AV11LegDedAnio) ,
                                           Integer.valueOf(AV8CliCod) ,
                                           Short.valueOf(AV9EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P00RV2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Short.valueOf(AV11LegDedAnio), Integer.valueOf(AV10LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A768LegDedAnio = P00RV2_A768LegDedAnio[0] ;
         A6LegNumero = P00RV2_A6LegNumero[0] ;
         A1EmpCod = P00RV2_A1EmpCod[0] ;
         A3CliCod = P00RV2_A3CliCod[0] ;
         A83LegDedSec = P00RV2_A83LegDedSec[0] ;
         /* Using cursor P00RV3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Integer.valueOf(A83LegDedSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("legajo_deducciones");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "deletededucciones");
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
      P00RV2_A768LegDedAnio = new short[1] ;
      P00RV2_A6LegNumero = new int[1] ;
      P00RV2_A1EmpCod = new short[1] ;
      P00RV2_A3CliCod = new int[1] ;
      P00RV2_A83LegDedSec = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.deletededucciones__default(),
         new Object[] {
             new Object[] {
            P00RV2_A768LegDedAnio, P00RV2_A6LegNumero, P00RV2_A1EmpCod, P00RV2_A3CliCod, P00RV2_A83LegDedSec
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV11LegDedAnio ;
   private short A768LegDedAnio ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A83LegDedSec ;
   private String scmdbuf ;
   private IDataStoreProvider pr_default ;
   private short[] P00RV2_A768LegDedAnio ;
   private int[] P00RV2_A6LegNumero ;
   private short[] P00RV2_A1EmpCod ;
   private int[] P00RV2_A3CliCod ;
   private int[] P00RV2_A83LegDedSec ;
}

final  class deletededucciones__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00RV2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV10LegNumero ,
                                          int A6LegNumero ,
                                          short A768LegDedAnio ,
                                          short AV11LegDedAnio ,
                                          int AV8CliCod ,
                                          short AV9EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[4];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT LegDedAnio, LegNumero, EmpCod, CliCod, LegDedSec FROM legajo_deducciones" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      addWhere(sWhereString, "(LegDedAnio = ?)");
      if ( ! (0==AV10LegNumero) )
      {
         addWhere(sWhereString, "(LegNumero = ?)");
      }
      else
      {
         GXv_int1[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      scmdbuf += " FOR UPDATE OF legajo_deducciones" ;
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
                  return conditional_P00RV2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00RV2", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00RV3", "SAVEPOINT gxupdate;DELETE FROM legajo_deducciones  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegDedSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((int[]) buf[4])[0] = rslt.getInt(5);
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
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

