package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getdatossubtipo1 extends GXProcedure
{
   public getdatossubtipo1( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getdatossubtipo1.class ), "" );
   }

   public getdatossubtipo1( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 )
   {
      getdatossubtipo1.this.aP2 = new String[] {""};
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
      getdatossubtipo1.this.AV8TipoConCod = aP0;
      getdatossubtipo1.this.AV9SubTipoConCod1 = aP1;
      getdatossubtipo1.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P018Y2 */
      pr_default.execute(0, new Object[] {AV8TipoConCod, AV9SubTipoConCod1});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A38SubTipoConCod1 = P018Y2_A38SubTipoConCod1[0] ;
         A37TipoConCod = P018Y2_A37TipoConCod[0] ;
         AV10SubTipoConDes1 = A38SubTipoConCod1 ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getdatossubtipo1.this.AV10SubTipoConDes1;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10SubTipoConDes1 = "" ;
      scmdbuf = "" ;
      P018Y2_A38SubTipoConCod1 = new String[] {""} ;
      P018Y2_A37TipoConCod = new String[] {""} ;
      A38SubTipoConCod1 = "" ;
      A37TipoConCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getdatossubtipo1__default(),
         new Object[] {
             new Object[] {
            P018Y2_A38SubTipoConCod1, P018Y2_A37TipoConCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8TipoConCod ;
   private String AV9SubTipoConCod1 ;
   private String scmdbuf ;
   private String A38SubTipoConCod1 ;
   private String A37TipoConCod ;
   private String AV10SubTipoConDes1 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P018Y2_A38SubTipoConCod1 ;
   private String[] P018Y2_A37TipoConCod ;
}

final  class getdatossubtipo1__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P018Y2", "SELECT SubTipoConCod1, TipoConCod FROM TipoDeConceptoSubtipo1 WHERE TipoConCod = ( ?) and SubTipoConCod1 = ( ?) ORDER BY TipoConCod, SubTipoConCod1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

