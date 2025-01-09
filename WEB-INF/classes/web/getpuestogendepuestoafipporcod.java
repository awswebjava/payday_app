package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpuestogendepuestoafipporcod extends GXProcedure
{
   public getpuestogendepuestoafipporcod( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpuestogendepuestoafipporcod.class ), "" );
   }

   public getpuestogendepuestoafipporcod( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      getpuestogendepuestoafipporcod.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      getpuestogendepuestoafipporcod.this.AV9PueAfipCod = aP0;
      getpuestogendepuestoafipporcod.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P025C2 */
      pr_default.execute(0, new Object[] {AV9PueAfipCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2213PueAfipCod = P025C2_A2213PueAfipCod[0] ;
         A2241PueAfipGenDes = P025C2_A2241PueAfipGenDes[0] ;
         AV8PueAfipGenDes = A2241PueAfipGenDes ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getpuestogendepuestoafipporcod.this.AV8PueAfipGenDes;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8PueAfipGenDes = "" ;
      scmdbuf = "" ;
      P025C2_A2213PueAfipCod = new String[] {""} ;
      P025C2_A2241PueAfipGenDes = new String[] {""} ;
      A2213PueAfipCod = "" ;
      A2241PueAfipGenDes = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpuestogendepuestoafipporcod__default(),
         new Object[] {
             new Object[] {
            P025C2_A2213PueAfipCod, P025C2_A2241PueAfipGenDes
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9PueAfipCod ;
   private String scmdbuf ;
   private String A2213PueAfipCod ;
   private String AV8PueAfipGenDes ;
   private String A2241PueAfipGenDes ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P025C2_A2213PueAfipCod ;
   private String[] P025C2_A2241PueAfipGenDes ;
}

final  class getpuestogendepuestoafipporcod__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P025C2", "SELECT PueAfipCod, PueAfipGenDes FROM PuestoAfip WHERE PueAfipCod = ( ?) ORDER BY PueAfipCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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
               stmt.setString(1, (String)parms[0], 4);
               return;
      }
   }

}

