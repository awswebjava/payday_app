package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpuestoafippordescripsinac extends GXProcedure
{
   public getpuestoafippordescripsinac( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpuestoafippordescripsinac.class ), "" );
   }

   public getpuestoafippordescripsinac( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String[] aP1 )
   {
      getpuestoafippordescripsinac.this.aP2 = new boolean[] {false};
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
      getpuestoafippordescripsinac.this.AV8PueAfipDes = aP0;
      getpuestoafippordescripsinac.this.aP1 = aP1;
      getpuestoafippordescripsinac.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P025R2 */
      pr_default.execute(0, new Object[] {AV8PueAfipDes});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2242PueAfipDesSinAc = P025R2_A2242PueAfipDesSinAc[0] ;
         A2213PueAfipCod = P025R2_A2213PueAfipCod[0] ;
         AV10PueAfipCod = A2213PueAfipCod ;
         AV9existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getpuestoafippordescripsinac.this.AV10PueAfipCod;
      this.aP2[0] = getpuestoafippordescripsinac.this.AV9existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10PueAfipCod = "" ;
      scmdbuf = "" ;
      P025R2_A2242PueAfipDesSinAc = new String[] {""} ;
      P025R2_A2213PueAfipCod = new String[] {""} ;
      A2242PueAfipDesSinAc = "" ;
      A2213PueAfipCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpuestoafippordescripsinac__default(),
         new Object[] {
             new Object[] {
            P025R2_A2242PueAfipDesSinAc, P025R2_A2213PueAfipCod
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
   private String A2242PueAfipDesSinAc ;
   private boolean[] aP2 ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P025R2_A2242PueAfipDesSinAc ;
   private String[] P025R2_A2213PueAfipCod ;
}

final  class getpuestoafippordescripsinac__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P025R2", "SELECT PueAfipDesSinAc, PueAfipCod FROM PuestoAfip WHERE PueAfipDesSinAc = ( ?) ORDER BY PueAfipCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
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
               stmt.setVarchar(1, (String)parms[0], 400);
               return;
      }
   }

}

