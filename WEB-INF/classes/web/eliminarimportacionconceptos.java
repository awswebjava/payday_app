package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class eliminarimportacionconceptos extends GXProcedure
{
   public eliminarimportacionconceptos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( eliminarimportacionconceptos.class ), "" );
   }

   public eliminarimportacionconceptos( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        String aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String aP3 )
   {
      eliminarimportacionconceptos.this.AV9CliCod = aP0;
      eliminarimportacionconceptos.this.AV8EmpCod = aP1;
      eliminarimportacionconceptos.this.AV10ImpLiqSec = aP2;
      eliminarimportacionconceptos.this.AV12ImpLiqConExtCod = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV12ImpLiqConExtCod ,
                                           A89ImpLiqConExtCod ,
                                           Integer.valueOf(AV9CliCod) ,
                                           Short.valueOf(AV8EmpCod) ,
                                           Short.valueOf(AV10ImpLiqSec) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Short.valueOf(A88ImpLiqSec) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P00N82 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV8EmpCod), Short.valueOf(AV10ImpLiqSec), AV12ImpLiqConExtCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A89ImpLiqConExtCod = P00N82_A89ImpLiqConExtCod[0] ;
         A88ImpLiqSec = P00N82_A88ImpLiqSec[0] ;
         A1EmpCod = P00N82_A1EmpCod[0] ;
         A3CliCod = P00N82_A3CliCod[0] ;
         /* Using cursor P00N83 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), A89ImpLiqConExtCod});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_conceptos");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "eliminarimportacionconceptos");
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
      A89ImpLiqConExtCod = "" ;
      P00N82_A89ImpLiqConExtCod = new String[] {""} ;
      P00N82_A88ImpLiqSec = new short[1] ;
      P00N82_A1EmpCod = new short[1] ;
      P00N82_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.eliminarimportacionconceptos__default(),
         new Object[] {
             new Object[] {
            P00N82_A89ImpLiqConExtCod, P00N82_A88ImpLiqSec, P00N82_A1EmpCod, P00N82_A3CliCod
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
   private short A1EmpCod ;
   private short A88ImpLiqSec ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String AV12ImpLiqConExtCod ;
   private String scmdbuf ;
   private String A89ImpLiqConExtCod ;
   private IDataStoreProvider pr_default ;
   private String[] P00N82_A89ImpLiqConExtCod ;
   private short[] P00N82_A88ImpLiqSec ;
   private short[] P00N82_A1EmpCod ;
   private int[] P00N82_A3CliCod ;
}

final  class eliminarimportacionconceptos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00N82( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12ImpLiqConExtCod ,
                                          String A89ImpLiqConExtCod ,
                                          int AV9CliCod ,
                                          short AV8EmpCod ,
                                          short AV10ImpLiqSec ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          short A88ImpLiqSec )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[4];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT ImpLiqConExtCod, ImpLiqSec, EmpCod, CliCod FROM importacion_conceptos" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and ImpLiqSec = ?)");
      if ( ! (GXutil.strcmp("", AV12ImpLiqConExtCod)==0) )
      {
         addWhere(sWhereString, "(ImpLiqConExtCod = ( ?))");
      }
      else
      {
         GXv_int1[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, ImpLiqSec" ;
      scmdbuf += " FOR UPDATE OF importacion_conceptos" ;
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
                  return conditional_P00N82(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00N82", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00N83", "SAVEPOINT gxupdate;DELETE FROM importacion_conceptos  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqConExtCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
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
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
      }
   }

}

