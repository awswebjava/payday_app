package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getproximafechavariable extends GXProcedure
{
   public getproximafechavariable( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getproximafechavariable.class ), "" );
   }

   public getproximafechavariable( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     String aP1 ,
                                     java.util.Date aP2 )
   {
      getproximafechavariable.this.aP3 = new java.util.Date[] {GXutil.nullDate()};
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
      getproximafechavariable.this.AV10CliCod = aP0;
      getproximafechavariable.this.AV9OpeCliId = aP1;
      getproximafechavariable.this.AV8OpeCliVig = aP2;
      getproximafechavariable.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02CS2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), AV9OpeCliId, AV8OpeCliVig});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A754OpeCliVig = P02CS2_A754OpeCliVig[0] ;
         A82OpeCliId = P02CS2_A82OpeCliId[0] ;
         A3CliCod = P02CS2_A3CliCod[0] ;
         AV11proximaOpeCliVig = A754OpeCliVig ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getproximafechavariable.this.AV11proximaOpeCliVig;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11proximaOpeCliVig = GXutil.nullDate() ;
      scmdbuf = "" ;
      P02CS2_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      P02CS2_A82OpeCliId = new String[] {""} ;
      P02CS2_A3CliCod = new int[1] ;
      A754OpeCliVig = GXutil.nullDate() ;
      A82OpeCliId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getproximafechavariable__default(),
         new Object[] {
             new Object[] {
            P02CS2_A754OpeCliVig, P02CS2_A82OpeCliId, P02CS2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String AV9OpeCliId ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private java.util.Date AV8OpeCliVig ;
   private java.util.Date AV11proximaOpeCliVig ;
   private java.util.Date A754OpeCliVig ;
   private java.util.Date[] aP3 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P02CS2_A754OpeCliVig ;
   private String[] P02CS2_A82OpeCliId ;
   private int[] P02CS2_A3CliCod ;
}

final  class getproximafechavariable__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02CS2", "SELECT OpeCliVig, OpeCliId, CliCod FROM variable_valores WHERE (CliCod = ? and OpeCliId = ( ?)) AND (OpeCliVig > ?) ORDER BY CliCod, OpeCliId, OpeCliVig DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
      }
   }

}

