package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcountperiodos extends GXProcedure
{
   public getcountperiodos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcountperiodos.class ), "" );
   }

   public getcountperiodos( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            short aP2 )
   {
      getcountperiodos.this.aP3 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        short[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             short[] aP3 )
   {
      getcountperiodos.this.AV11CliCod = aP0;
      getcountperiodos.this.AV8EmpCod = aP1;
      getcountperiodos.this.AV9PeriodoAnio = aP2;
      getcountperiodos.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized group. */
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Short.valueOf(AV9PeriodoAnio) ,
                                           Short.valueOf(A1730PeriodoAnio) } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P02GI2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV8EmpCod), Short.valueOf(AV9PeriodoAnio)});
      cV10cnt = P02GI2_AV10cnt[0] ;
      pr_default.close(0);
      AV10cnt = (short)(AV10cnt+cV10cnt*1) ;
      /* End optimized group. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getcountperiodos.this.AV10cnt;
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
      P02GI2_AV10cnt = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getcountperiodos__default(),
         new Object[] {
             new Object[] {
            P02GI2_AV10cnt
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short AV9PeriodoAnio ;
   private short AV10cnt ;
   private short A1730PeriodoAnio ;
   private short cV10cnt ;
   private short Gx_err ;
   private int AV11CliCod ;
   private String scmdbuf ;
   private short[] aP3 ;
   private IDataStoreProvider pr_default ;
   private short[] P02GI2_AV10cnt ;
}

final  class getcountperiodos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02GI2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV9PeriodoAnio ,
                                          short A1730PeriodoAnio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[3];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM Periodo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV9PeriodoAnio) )
      {
         addWhere(sWhereString, "(PeriodoAnio = ?)");
      }
      else
      {
         GXv_int1[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
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
                  return conditional_P02GI2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Number) dynConstraints[1]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02GI2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
      }
   }

}

