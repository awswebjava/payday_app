package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class eliminarmigrleg extends GXProcedure
{
   public eliminarmigrleg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( eliminarmigrleg.class ), "" );
   }

   public eliminarmigrleg( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      eliminarmigrleg.this.AV9CliCod = aP0;
      eliminarmigrleg.this.AV8EmpCod = aP1;
      eliminarmigrleg.this.AV10MigrLegNumero = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, httpContext.getMessage( "clicod ", "")+GXutil.trim( GXutil.str( AV9CliCod, 6, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV8EmpCod, 4, 0))) ;
      AV14GXLvl2 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV10MigrLegNumero) ,
                                           Integer.valueOf(A87MigrLegNumero) ,
                                           Integer.valueOf(AV9CliCod) ,
                                           Short.valueOf(AV8EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P00MX2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10MigrLegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A87MigrLegNumero = P00MX2_A87MigrLegNumero[0] ;
         A1EmpCod = P00MX2_A1EmpCod[0] ;
         A3CliCod = P00MX2_A3CliCod[0] ;
         AV14GXLvl2 = (byte)(1) ;
         /* Optimized DELETE. */
         /* Using cursor P00MX3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajoFamilia");
         /* End optimized DELETE. */
         /* Using cursor P00MX4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajo");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV14GXLvl2 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "eliminarmigrleg");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13Pgmname = "" ;
      scmdbuf = "" ;
      P00MX2_A87MigrLegNumero = new int[1] ;
      P00MX2_A1EmpCod = new short[1] ;
      P00MX2_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.eliminarmigrleg__default(),
         new Object[] {
             new Object[] {
            P00MX2_A87MigrLegNumero, P00MX2_A1EmpCod, P00MX2_A3CliCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV13Pgmname = "EliminarMigrLeg" ;
      /* GeneXus formulas. */
      AV13Pgmname = "EliminarMigrLeg" ;
      Gx_err = (short)(0) ;
   }

   private byte AV14GXLvl2 ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV10MigrLegNumero ;
   private int A87MigrLegNumero ;
   private int A3CliCod ;
   private String AV13Pgmname ;
   private String scmdbuf ;
   private IDataStoreProvider pr_default ;
   private int[] P00MX2_A87MigrLegNumero ;
   private short[] P00MX2_A1EmpCod ;
   private int[] P00MX2_A3CliCod ;
}

final  class eliminarmigrleg__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00MX2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV10MigrLegNumero ,
                                          int A87MigrLegNumero ,
                                          int AV9CliCod ,
                                          short AV8EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[3];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT MigrLegNumero, EmpCod, CliCod FROM importacion_legajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV10MigrLegNumero) )
      {
         addWhere(sWhereString, "(MigrLegNumero = ?)");
      }
      else
      {
         GXv_int1[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      scmdbuf += " FOR UPDATE OF importacion_legajo" ;
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
                  return conditional_P00MX2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00MX2", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00MX3", "DELETE FROM importacion_legajoFamilia  WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00MX4", "SAVEPOINT gxupdate;DELETE FROM importacion_legajo  WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

