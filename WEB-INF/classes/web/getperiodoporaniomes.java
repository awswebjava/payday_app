package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getperiodoporaniomes extends GXProcedure
{
   public getperiodoporaniomes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getperiodoporaniomes.class ), "" );
   }

   public getperiodoporaniomes( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              java.util.Date[] aP3 )
   {
      getperiodoporaniomes.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date[] aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date[] aP3 ,
                             boolean[] aP4 )
   {
      getperiodoporaniomes.this.AV12CliCod = aP0;
      getperiodoporaniomes.this.AV11EmpCod = aP1;
      getperiodoporaniomes.this.AV10PeriodoAnioMes = aP2;
      getperiodoporaniomes.this.aP3 = aP3;
      getperiodoporaniomes.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8existe = false ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Short.valueOf(AV11EmpCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A2103PeriodoAnioMes) ,
                                           Integer.valueOf(AV10PeriodoAnioMes) ,
                                           Integer.valueOf(AV12CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P021F2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Integer.valueOf(AV10PeriodoAnioMes), Short.valueOf(AV11EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2103PeriodoAnioMes = P021F2_A2103PeriodoAnioMes[0] ;
         A1EmpCod = P021F2_A1EmpCod[0] ;
         A3CliCod = P021F2_A3CliCod[0] ;
         A1729PeriodoLiq = P021F2_A1729PeriodoLiq[0] ;
         AV9PeriodoLiq = A1729PeriodoLiq ;
         AV8existe = true ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getperiodoporaniomes.this.AV9PeriodoLiq;
      this.aP4[0] = getperiodoporaniomes.this.AV8existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9PeriodoLiq = GXutil.nullDate() ;
      scmdbuf = "" ;
      P021F2_A2103PeriodoAnioMes = new int[1] ;
      P021F2_A1EmpCod = new short[1] ;
      P021F2_A3CliCod = new int[1] ;
      P021F2_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      A1729PeriodoLiq = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getperiodoporaniomes__default(),
         new Object[] {
             new Object[] {
            P021F2_A2103PeriodoAnioMes, P021F2_A1EmpCod, P021F2_A3CliCod, P021F2_A1729PeriodoLiq
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV10PeriodoAnioMes ;
   private int A2103PeriodoAnioMes ;
   private int A3CliCod ;
   private String scmdbuf ;
   private java.util.Date AV9PeriodoLiq ;
   private java.util.Date A1729PeriodoLiq ;
   private boolean AV8existe ;
   private boolean[] aP4 ;
   private java.util.Date[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P021F2_A2103PeriodoAnioMes ;
   private short[] P021F2_A1EmpCod ;
   private int[] P021F2_A3CliCod ;
   private java.util.Date[] P021F2_A1729PeriodoLiq ;
}

final  class getperiodoporaniomes__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P021F2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV11EmpCod ,
                                          short A1EmpCod ,
                                          int A2103PeriodoAnioMes ,
                                          int AV10PeriodoAnioMes ,
                                          int AV12CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[3];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT PeriodoAnioMes, EmpCod, CliCod, PeriodoLiq FROM Periodo" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(PeriodoAnioMes = ?)");
      if ( ! (0==AV11EmpCod) )
      {
         addWhere(sWhereString, "(EmpCod = ?)");
      }
      else
      {
         GXv_int1[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
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
                  return conditional_P021F2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P021F2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
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
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               return;
      }
   }

}

