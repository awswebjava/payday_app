package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcondexencioniigg extends GXProcedure
{
   public getcondexencioniigg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcondexencioniigg.class ), "" );
   }

   public getcondexencioniigg( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 ,
                             java.math.BigDecimal[] aP4 )
   {
      getcondexencioniigg.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        String[] aP3 ,
                        java.math.BigDecimal[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 ,
                             java.math.BigDecimal[] aP4 ,
                             String[] aP5 )
   {
      getcondexencioniigg.this.AV12CliCod = aP0;
      getcondexencioniigg.this.AV13CondExenIIGG = aP1;
      getcondexencioniigg.this.aP2 = aP2;
      getcondexencioniigg.this.aP3 = aP3;
      getcondexencioniigg.this.aP4 = aP4;
      getcondexencioniigg.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P026Y2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), AV13CondExenIIGG});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1105CondExenIIGG = P026Y2_A1105CondExenIIGG[0] ;
         A3CliCod = P026Y2_A3CliCod[0] ;
         A1104CondExenIIGGCon = P026Y2_A1104CondExenIIGGCon[0] ;
         A1123CondExenIIGGVar = P026Y2_A1123CondExenIIGGVar[0] ;
         n1123CondExenIIGGVar = P026Y2_n1123CondExenIIGGVar[0] ;
         A2237CondExenIIGGVFi = P026Y2_A2237CondExenIIGGVFi[0] ;
         A2238CondExenIIGGOpe = P026Y2_A2238CondExenIIGGOpe[0] ;
         AV8CondExenIIGGCon = A1104CondExenIIGGCon ;
         AV9CondExenIIGGVar = A1123CondExenIIGGVar ;
         AV10CondExenIIGGVFi = A2237CondExenIIGGVFi ;
         AV11CondExenIIGGOpe = A2238CondExenIIGGOpe ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getcondexencioniigg.this.AV8CondExenIIGGCon;
      this.aP3[0] = getcondexencioniigg.this.AV9CondExenIIGGVar;
      this.aP4[0] = getcondexencioniigg.this.AV10CondExenIIGGVFi;
      this.aP5[0] = getcondexencioniigg.this.AV11CondExenIIGGOpe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8CondExenIIGGCon = "" ;
      AV9CondExenIIGGVar = "" ;
      AV10CondExenIIGGVFi = DecimalUtil.ZERO ;
      AV11CondExenIIGGOpe = "" ;
      scmdbuf = "" ;
      P026Y2_A1105CondExenIIGG = new String[] {""} ;
      P026Y2_A3CliCod = new int[1] ;
      P026Y2_A1104CondExenIIGGCon = new String[] {""} ;
      P026Y2_A1123CondExenIIGGVar = new String[] {""} ;
      P026Y2_n1123CondExenIIGGVar = new boolean[] {false} ;
      P026Y2_A2237CondExenIIGGVFi = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P026Y2_A2238CondExenIIGGOpe = new String[] {""} ;
      A1105CondExenIIGG = "" ;
      A1104CondExenIIGGCon = "" ;
      A1123CondExenIIGGVar = "" ;
      A2237CondExenIIGGVFi = DecimalUtil.ZERO ;
      A2238CondExenIIGGOpe = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getcondexencioniigg__default(),
         new Object[] {
             new Object[] {
            P026Y2_A1105CondExenIIGG, P026Y2_A3CliCod, P026Y2_A1104CondExenIIGGCon, P026Y2_A1123CondExenIIGGVar, P026Y2_n1123CondExenIIGGVar, P026Y2_A2237CondExenIIGGVFi, P026Y2_A2238CondExenIIGGOpe
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV12CliCod ;
   private int A3CliCod ;
   private java.math.BigDecimal AV10CondExenIIGGVFi ;
   private java.math.BigDecimal A2237CondExenIIGGVFi ;
   private String AV13CondExenIIGG ;
   private String AV8CondExenIIGGCon ;
   private String AV9CondExenIIGGVar ;
   private String AV11CondExenIIGGOpe ;
   private String scmdbuf ;
   private String A1105CondExenIIGG ;
   private String A1104CondExenIIGGCon ;
   private String A1123CondExenIIGGVar ;
   private String A2238CondExenIIGGOpe ;
   private boolean n1123CondExenIIGGVar ;
   private String[] aP5 ;
   private String[] aP2 ;
   private String[] aP3 ;
   private java.math.BigDecimal[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P026Y2_A1105CondExenIIGG ;
   private int[] P026Y2_A3CliCod ;
   private String[] P026Y2_A1104CondExenIIGGCon ;
   private String[] P026Y2_A1123CondExenIIGGVar ;
   private boolean[] P026Y2_n1123CondExenIIGGVar ;
   private java.math.BigDecimal[] P026Y2_A2237CondExenIIGGVFi ;
   private String[] P026Y2_A2238CondExenIIGGOpe ;
}

final  class getcondexencioniigg__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P026Y2", "SELECT CondExenIIGG, CliCod, CondExenIIGGCon, CondExenIIGGVar, CondExenIIGGVFi, CondExenIIGGOpe FROM condicion_exencion_iigg WHERE CliCod = ? and CondExenIIGG = ( ?) ORDER BY CliCod, CondExenIIGG ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,2);
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

