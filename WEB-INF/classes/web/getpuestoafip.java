package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpuestoafip extends GXProcedure
{
   public getpuestoafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpuestoafip.class ), "" );
   }

   public getpuestoafip( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String[] aP1 )
   {
      getpuestoafip.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 ,
                             boolean[] aP2 )
   {
      getpuestoafip.this.AV10PueAfipCod = aP0;
      getpuestoafip.this.aP1 = aP1;
      getpuestoafip.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P025Q2 */
      pr_default.execute(0, new Object[] {AV10PueAfipCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2213PueAfipCod = P025Q2_A2213PueAfipCod[0] ;
         A2214PueAfipDes = P025Q2_A2214PueAfipDes[0] ;
         AV8PueAfipDes = A2214PueAfipDes ;
         AV9existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getpuestoafip.this.AV8PueAfipDes;
      this.aP2[0] = getpuestoafip.this.AV9existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8PueAfipDes = "" ;
      scmdbuf = "" ;
      P025Q2_A2213PueAfipCod = new String[] {""} ;
      P025Q2_A2214PueAfipDes = new String[] {""} ;
      A2213PueAfipCod = "" ;
      A2214PueAfipDes = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpuestoafip__default(),
         new Object[] {
             new Object[] {
            P025Q2_A2213PueAfipCod, P025Q2_A2214PueAfipDes
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10PueAfipCod ;
   private String scmdbuf ;
   private String A2213PueAfipCod ;
   private boolean AV9existe ;
   private String AV8PueAfipDes ;
   private String A2214PueAfipDes ;
   private boolean[] aP2 ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P025Q2_A2213PueAfipCod ;
   private String[] P025Q2_A2214PueAfipDes ;
}

final  class getpuestoafip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P025Q2", "SELECT PueAfipCod, PueAfipDes FROM PuestoAfip WHERE PueAfipCod = ( ?) ORDER BY PueAfipCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

