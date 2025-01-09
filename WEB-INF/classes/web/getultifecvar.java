package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getultifecvar extends GXProcedure
{
   public getultifecvar( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getultifecvar.class ), "" );
   }

   public getultifecvar( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     String aP1 ,
                                     java.util.Date aP2 )
   {
      getultifecvar.this.aP3 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        java.util.Date aP2 ,
                        java.util.Date[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             java.util.Date aP2 ,
                             java.util.Date[] aP3 )
   {
      getultifecvar.this.AV8CliCod = aP0;
      getultifecvar.this.AV9OpeCliId = aP1;
      getultifecvar.this.AV11OpeCliVig = aP2;
      getultifecvar.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV11OpeCliVig ,
                                           A754OpeCliVig ,
                                           Integer.valueOf(AV8CliCod) ,
                                           AV9OpeCliId ,
                                           Integer.valueOf(A3CliCod) ,
                                           A82OpeCliId } ,
                                           new int[]{
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING
                                           }
      });
      /* Using cursor P01UG2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9OpeCliId, AV11OpeCliVig});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A754OpeCliVig = P01UG2_A754OpeCliVig[0] ;
         A82OpeCliId = P01UG2_A82OpeCliId[0] ;
         A3CliCod = P01UG2_A3CliCod[0] ;
         AV10ultiOpeCliVig = A754OpeCliVig ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getultifecvar.this.AV10ultiOpeCliVig;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ultiOpeCliVig = GXutil.nullDate() ;
      scmdbuf = "" ;
      A754OpeCliVig = GXutil.nullDate() ;
      A82OpeCliId = "" ;
      P01UG2_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01UG2_A82OpeCliId = new String[] {""} ;
      P01UG2_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getultifecvar__default(),
         new Object[] {
             new Object[] {
            P01UG2_A754OpeCliVig, P01UG2_A82OpeCliId, P01UG2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9OpeCliId ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private java.util.Date AV11OpeCliVig ;
   private java.util.Date AV10ultiOpeCliVig ;
   private java.util.Date A754OpeCliVig ;
   private java.util.Date[] aP3 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P01UG2_A754OpeCliVig ;
   private String[] P01UG2_A82OpeCliId ;
   private int[] P01UG2_A3CliCod ;
}

final  class getultifecvar__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01UG2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          java.util.Date AV11OpeCliVig ,
                                          java.util.Date A754OpeCliVig ,
                                          int AV8CliCod ,
                                          String AV9OpeCliId ,
                                          int A3CliCod ,
                                          String A82OpeCliId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[3];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT OpeCliVig, OpeCliId, CliCod FROM variable_valores" ;
      addWhere(sWhereString, "(CliCod = ? and OpeCliId = ( ?))");
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV11OpeCliVig)) )
      {
         addWhere(sWhereString, "(OpeCliVig <= ?)");
      }
      else
      {
         GXv_int1[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, OpeCliId, OpeCliVig DESC" ;
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
                  return conditional_P01UG2(context, remoteHandle, httpContext, (java.util.Date)dynConstraints[0] , (java.util.Date)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01UG2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
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
                  stmt.setString(sIdx, (String)parms[4], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[5]);
               }
               return;
      }
   }

}

