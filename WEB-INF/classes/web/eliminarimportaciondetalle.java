package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class eliminarimportaciondetalle extends GXProcedure
{
   public eliminarimportaciondetalle( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( eliminarimportaciondetalle.class ), "" );
   }

   public eliminarimportaciondetalle( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        short aP3 ,
                        String aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             short aP3 ,
                             String aP4 )
   {
      eliminarimportaciondetalle.this.AV9CliCod = aP0;
      eliminarimportaciondetalle.this.AV8EmpCod = aP1;
      eliminarimportaciondetalle.this.AV10ImpLiqSec = aP2;
      eliminarimportaciondetalle.this.AV12ImpLiqDetSec = aP3;
      eliminarimportaciondetalle.this.AV14cuilesJSON = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV13ImpLiqLSDCuil.fromJSonString(AV14cuilesJSON, null);
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Long.valueOf(A1770ImpLiqLSDCuil) ,
                                           AV13ImpLiqLSDCuil ,
                                           Integer.valueOf(AV13ImpLiqLSDCuil.size()) ,
                                           Integer.valueOf(AV9CliCod) ,
                                           Short.valueOf(AV8EmpCod) ,
                                           Short.valueOf(AV10ImpLiqSec) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(A88ImpLiqSec) } ,
                                           new int[]{
                                           TypeConstants.LONG, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P00O82 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV8EmpCod), Short.valueOf(AV10ImpLiqSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1770ImpLiqLSDCuil = P00O82_A1770ImpLiqLSDCuil[0] ;
         A88ImpLiqSec = P00O82_A88ImpLiqSec[0] ;
         A1EmpCod = P00O82_A1EmpCod[0] ;
         A3CliCod = P00O82_A3CliCod[0] ;
         /* Using cursor P00O83 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Long.valueOf(A1770ImpLiqLSDCuil)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion_lsd_legajos");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           Short.valueOf(AV12ImpLiqDetSec) ,
                                           Integer.valueOf(AV13ImpLiqLSDCuil.size()) ,
                                           Short.valueOf(A90ImpLiqDetSec) ,
                                           A709ImpLiqDetError ,
                                           Integer.valueOf(AV9CliCod) ,
                                           Short.valueOf(AV8EmpCod) ,
                                           Short.valueOf(AV10ImpLiqSec) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(A88ImpLiqSec) } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P00O84 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV8EmpCod), Short.valueOf(AV10ImpLiqSec), Short.valueOf(AV12ImpLiqDetSec)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A709ImpLiqDetError = P00O84_A709ImpLiqDetError[0] ;
         A90ImpLiqDetSec = P00O84_A90ImpLiqDetSec[0] ;
         A88ImpLiqSec = P00O84_A88ImpLiqSec[0] ;
         A1EmpCod = P00O84_A1EmpCod[0] ;
         A3CliCod = P00O84_A3CliCod[0] ;
         /* Using cursor P00O85 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A90ImpLiqDetSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion_detalle");
         pr_default.readNext(2);
      }
      pr_default.close(2);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "eliminarimportaciondetalle");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13ImpLiqLSDCuil = new GXSimpleCollection<Long>(Long.class, "internal", "");
      scmdbuf = "" ;
      P00O82_A1770ImpLiqLSDCuil = new long[1] ;
      P00O82_A88ImpLiqSec = new short[1] ;
      P00O82_A1EmpCod = new short[1] ;
      P00O82_A3CliCod = new int[1] ;
      A709ImpLiqDetError = "" ;
      P00O84_A709ImpLiqDetError = new String[] {""} ;
      P00O84_A90ImpLiqDetSec = new short[1] ;
      P00O84_A88ImpLiqSec = new short[1] ;
      P00O84_A1EmpCod = new short[1] ;
      P00O84_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.eliminarimportaciondetalle__default(),
         new Object[] {
             new Object[] {
            P00O82_A1770ImpLiqLSDCuil, P00O82_A88ImpLiqSec, P00O82_A1EmpCod, P00O82_A3CliCod
            }
            , new Object[] {
            }
            , new Object[] {
            P00O84_A709ImpLiqDetError, P00O84_A90ImpLiqDetSec, P00O84_A88ImpLiqSec, P00O84_A1EmpCod, P00O84_A3CliCod
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short AV10ImpLiqSec ;
   private short AV12ImpLiqDetSec ;
   private short A1EmpCod ;
   private short A88ImpLiqSec ;
   private short A90ImpLiqDetSec ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV13ImpLiqLSDCuil_size ;
   private int A3CliCod ;
   private long A1770ImpLiqLSDCuil ;
   private String scmdbuf ;
   private String AV14cuilesJSON ;
   private String A709ImpLiqDetError ;
   private GXSimpleCollection<Long> AV13ImpLiqLSDCuil ;
   private IDataStoreProvider pr_default ;
   private long[] P00O82_A1770ImpLiqLSDCuil ;
   private short[] P00O82_A88ImpLiqSec ;
   private short[] P00O82_A1EmpCod ;
   private int[] P00O82_A3CliCod ;
   private String[] P00O84_A709ImpLiqDetError ;
   private short[] P00O84_A90ImpLiqDetSec ;
   private short[] P00O84_A88ImpLiqSec ;
   private short[] P00O84_A1EmpCod ;
   private int[] P00O84_A3CliCod ;
}

final  class eliminarimportaciondetalle__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00O82( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          long A1770ImpLiqLSDCuil ,
                                          GXSimpleCollection<Long> AV13ImpLiqLSDCuil ,
                                          int AV13ImpLiqLSDCuil_size ,
                                          int AV9CliCod ,
                                          short AV8EmpCod ,
                                          short AV10ImpLiqSec ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          short A88ImpLiqSec )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[3];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT ImpLiqLSDCuil, ImpLiqSec, EmpCod, CliCod FROM importacion_liquidacion_lsd_legajos" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and ImpLiqSec = ?)");
      if ( AV13ImpLiqLSDCuil_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13ImpLiqLSDCuil, "ImpLiqLSDCuil IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, ImpLiqSec" ;
      scmdbuf += " FOR UPDATE OF importacion_liquidacion_lsd_legajos" ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
   }

   protected Object[] conditional_P00O84( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV12ImpLiqDetSec ,
                                          int AV13ImpLiqLSDCuil_size ,
                                          short A90ImpLiqDetSec ,
                                          String A709ImpLiqDetError ,
                                          int AV9CliCod ,
                                          short AV8EmpCod ,
                                          short AV10ImpLiqSec ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          short A88ImpLiqSec )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[4];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT ImpLiqDetError, ImpLiqDetSec, ImpLiqSec, EmpCod, CliCod FROM importacion_liquidacion_detalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and ImpLiqSec = ?)");
      if ( ! (0==AV12ImpLiqDetSec) )
      {
         addWhere(sWhereString, "(ImpLiqDetSec = ?)");
      }
      else
      {
         GXv_int4[3] = (byte)(1) ;
      }
      if ( AV13ImpLiqLSDCuil_size > 0 )
      {
         addWhere(sWhereString, "((char_length(trim(trailing ' ' from ImpLiqDetError))=0))");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, ImpLiqSec" ;
      scmdbuf += " FOR UPDATE OF importacion_liquidacion_detalle" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
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
                  return conditional_P00O82(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).longValue() , (GXSimpleCollection<Long>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() );
            case 2 :
                  return conditional_P00O84(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).shortValue() , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00O82", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00O83", "SAVEPOINT gxupdate;DELETE FROM importacion_liquidacion_lsd_legajos  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqLSDCuil = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00O84", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00O85", "SAVEPOINT gxupdate;DELETE FROM importacion_liquidacion_detalle  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqDetSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setLong(4, ((Number) parms[3]).longValue());
               return;
            case 2 :
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
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
      }
   }

}

