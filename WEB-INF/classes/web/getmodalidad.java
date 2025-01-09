package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmodalidad extends GXProcedure
{
   public getmodalidad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmodalidad.class ), "" );
   }

   public getmodalidad( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String[] aP1 )
   {
      getmodalidad.this.aP2 = new boolean[] {false};
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
      getmodalidad.this.AV9MprCod = aP0;
      getmodalidad.this.aP1 = aP1;
      getmodalidad.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00BA2 */
      pr_default.execute(0, new Object[] {AV9MprCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A18MprCod = P00BA2_A18MprCod[0] ;
         A303MprDescrip = P00BA2_A303MprDescrip[0] ;
         AV10MprDescrip = A303MprDescrip ;
         AV11existe = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getmodalidad.this.AV10MprDescrip;
      this.aP2[0] = getmodalidad.this.AV11existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10MprDescrip = "" ;
      scmdbuf = "" ;
      P00BA2_A18MprCod = new String[] {""} ;
      P00BA2_A303MprDescrip = new String[] {""} ;
      A18MprCod = "" ;
      A303MprDescrip = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getmodalidad__default(),
         new Object[] {
             new Object[] {
            P00BA2_A18MprCod, P00BA2_A303MprDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9MprCod ;
   private String scmdbuf ;
   private String A18MprCod ;
   private boolean AV11existe ;
   private String AV10MprDescrip ;
   private String A303MprDescrip ;
   private boolean[] aP2 ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P00BA2_A18MprCod ;
   private String[] P00BA2_A303MprDescrip ;
}

final  class getmodalidad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00BA2", "SELECT MprCod, MprDescrip FROM ModalidadAFIP WHERE MprCod = ( ?) ORDER BY MprCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

