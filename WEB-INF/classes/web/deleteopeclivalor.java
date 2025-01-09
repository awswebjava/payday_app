package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class deleteopeclivalor extends GXProcedure
{
   public deleteopeclivalor( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( deleteopeclivalor.class ), "" );
   }

   public deleteopeclivalor( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String aP1 )
   {
      deleteopeclivalor.this.AV9CliCod = aP0;
      deleteopeclivalor.this.AV8OpeCliId = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV9CliCod, 6, 0))+httpContext.getMessage( " &OpeCliId ", "")+GXutil.trim( AV8OpeCliId)) ;
      AV13GXLvl2 = (byte)(0) ;
      /* Using cursor P01922 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), AV8OpeCliId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A82OpeCliId = P01922_A82OpeCliId[0] ;
         A3CliCod = P01922_A3CliCod[0] ;
         A535OpeCliValor = P01922_A535OpeCliValor[0] ;
         A754OpeCliVig = P01922_A754OpeCliVig[0] ;
         AV13GXLvl2 = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, httpContext.getMessage( "delete ", "")+GXutil.trim( A535OpeCliValor)) ;
         /* Using cursor P01923 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("variable_valores");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV13GXLvl2 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV12Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "deleteopeclivalor");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Pgmname = "" ;
      scmdbuf = "" ;
      P01922_A82OpeCliId = new String[] {""} ;
      P01922_A3CliCod = new int[1] ;
      P01922_A535OpeCliValor = new String[] {""} ;
      P01922_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      A82OpeCliId = "" ;
      A535OpeCliValor = "" ;
      A754OpeCliVig = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.deleteopeclivalor__default(),
         new Object[] {
             new Object[] {
            P01922_A82OpeCliId, P01922_A3CliCod, P01922_A535OpeCliValor, P01922_A754OpeCliVig
            }
            , new Object[] {
            }
         }
      );
      AV12Pgmname = "deleteOpeCliValor" ;
      /* GeneXus formulas. */
      AV12Pgmname = "deleteOpeCliValor" ;
      Gx_err = (short)(0) ;
   }

   private byte AV13GXLvl2 ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String AV8OpeCliId ;
   private String AV12Pgmname ;
   private String scmdbuf ;
   private String A82OpeCliId ;
   private java.util.Date A754OpeCliVig ;
   private String A535OpeCliValor ;
   private IDataStoreProvider pr_default ;
   private String[] P01922_A82OpeCliId ;
   private int[] P01922_A3CliCod ;
   private String[] P01922_A535OpeCliValor ;
   private java.util.Date[] P01922_A754OpeCliVig ;
}

final  class deleteopeclivalor__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01922", "SELECT OpeCliId, CliCod, OpeCliValor, OpeCliVig FROM variable_valores WHERE CliCod = ? and OpeCliId = ( ?) ORDER BY CliCod, OpeCliId  FOR UPDATE OF variable_valores",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01923", "SAVEPOINT gxupdate;DELETE FROM variable_valores  WHERE CliCod = ? AND OpeCliId = ? AND OpeCliVig = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
      }
   }

}

