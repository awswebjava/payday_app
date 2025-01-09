package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class egresovalidar extends GXProcedure
{
   public egresovalidar( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( egresovalidar.class ), "" );
   }

   public egresovalidar( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              GXSimpleCollection<Integer> aP2 )
   {
      egresovalidar.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        GXSimpleCollection<Integer> aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             GXSimpleCollection<Integer> aP2 ,
                             boolean[] aP3 )
   {
      egresovalidar.this.AV8CliCod = aP0;
      egresovalidar.this.AV11EmpCod = aP1;
      egresovalidar.this.AV9LegNumero = aP2;
      egresovalidar.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10ok = true ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(A6LegNumero) ,
                                           AV9LegNumero ,
                                           Integer.valueOf(AV8CliCod) ,
                                           Short.valueOf(AV11EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P00UC2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV11EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P00UC2_A6LegNumero[0] ;
         A1EmpCod = P00UC2_A1EmpCod[0] ;
         A3CliCod = P00UC2_A3CliCod[0] ;
         A244LegFecEgreso = P00UC2_A244LegFecEgreso[0] ;
         n244LegFecEgreso = P00UC2_n244LegFecEgreso[0] ;
         if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A244LegFecEgreso)) )
         {
            AV10ok = false ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = egresovalidar.this.AV10ok;
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
      P00UC2_A6LegNumero = new int[1] ;
      P00UC2_A1EmpCod = new short[1] ;
      P00UC2_A3CliCod = new int[1] ;
      P00UC2_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      P00UC2_n244LegFecEgreso = new boolean[] {false} ;
      A244LegFecEgreso = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.egresovalidar__default(),
         new Object[] {
             new Object[] {
            P00UC2_A6LegNumero, P00UC2_A1EmpCod, P00UC2_A3CliCod, P00UC2_A244LegFecEgreso, P00UC2_n244LegFecEgreso
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private java.util.Date A244LegFecEgreso ;
   private boolean AV10ok ;
   private boolean n244LegFecEgreso ;
   private GXSimpleCollection<Integer> AV9LegNumero ;
   private boolean[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00UC2_A6LegNumero ;
   private short[] P00UC2_A1EmpCod ;
   private int[] P00UC2_A3CliCod ;
   private java.util.Date[] P00UC2_A244LegFecEgreso ;
   private boolean[] P00UC2_n244LegFecEgreso ;
}

final  class egresovalidar__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00UC2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int A6LegNumero ,
                                          GXSimpleCollection<Integer> AV9LegNumero ,
                                          int AV8CliCod ,
                                          short AV11EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[2];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT LegNumero, EmpCod, CliCod, LegFecEgreso FROM Legajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV9LegNumero, "LegNumero IN (", ")")+")");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
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
                  return conditional_P00UC2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , (GXSimpleCollection<Integer>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00UC2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[4])[0] = rslt.wasNull();
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
                  stmt.setInt(sIdx, ((Number) parms[2]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[3]).shortValue());
               }
               return;
      }
   }

}

