package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsubtipo1por2 extends GXProcedure
{
   public getsubtipo1por2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsubtipo1por2.class ), "" );
   }

   public getsubtipo1por2( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 )
   {
      getsubtipo1por2.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      getsubtipo1por2.this.AV8TipoConCod = aP0;
      getsubtipo1por2.this.AV9SubTipoConCod2 = aP1;
      getsubtipo1por2.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P012P2 */
      pr_default.execute(0, new Object[] {AV8TipoConCod, AV9SubTipoConCod2});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A39SubTipoConCod2 = P012P2_A39SubTipoConCod2[0] ;
         A37TipoConCod = P012P2_A37TipoConCod[0] ;
         A38SubTipoConCod1 = P012P2_A38SubTipoConCod1[0] ;
         AV10SubTipoConCod1 = A38SubTipoConCod1 ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getsubtipo1por2.this.AV10SubTipoConCod1;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10SubTipoConCod1 = "" ;
      scmdbuf = "" ;
      P012P2_A39SubTipoConCod2 = new String[] {""} ;
      P012P2_A37TipoConCod = new String[] {""} ;
      P012P2_A38SubTipoConCod1 = new String[] {""} ;
      A39SubTipoConCod2 = "" ;
      A37TipoConCod = "" ;
      A38SubTipoConCod1 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsubtipo1por2__default(),
         new Object[] {
             new Object[] {
            P012P2_A39SubTipoConCod2, P012P2_A37TipoConCod, P012P2_A38SubTipoConCod1
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8TipoConCod ;
   private String AV9SubTipoConCod2 ;
   private String AV10SubTipoConCod1 ;
   private String scmdbuf ;
   private String A39SubTipoConCod2 ;
   private String A37TipoConCod ;
   private String A38SubTipoConCod1 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P012P2_A39SubTipoConCod2 ;
   private String[] P012P2_A37TipoConCod ;
   private String[] P012P2_A38SubTipoConCod1 ;
}

final  class getsubtipo1por2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P012P2", "SELECT SubTipoConCod2, TipoConCod, SubTipoConCod1 FROM tipo_concepto_subtipo2 WHERE (TipoConCod = ( ?)) AND (SubTipoConCod2 = ( ?)) ORDER BY TipoConCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

