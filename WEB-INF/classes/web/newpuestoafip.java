package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newpuestoafip extends GXProcedure
{
   public newpuestoafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newpuestoafip.class ), "" );
   }

   public newpuestoafip( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 )
   {
      newpuestoafip.this.AV8PueAfipCod = aP0;
      newpuestoafip.this.AV9PueAfipDes = aP1;
      newpuestoafip.this.AV10PueAfipGenDes = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE PuestoAfip

      */
      A2213PueAfipCod = AV8PueAfipCod ;
      A2214PueAfipDes = AV9PueAfipDes ;
      A2241PueAfipGenDes = AV10PueAfipGenDes ;
      GXv_char1[0] = AV11PueAfipDesSinAc ;
      new web.sacaracentos2(remoteHandle, context).execute( AV9PueAfipDes, GXv_char1) ;
      newpuestoafip.this.AV11PueAfipDesSinAc = GXv_char1[0] ;
      A2242PueAfipDesSinAc = GXutil.upper( AV11PueAfipDesSinAc) ;
      /* Using cursor P028B2 */
      pr_default.execute(0, new Object[] {A2213PueAfipCod, A2214PueAfipDes, A2241PueAfipGenDes, A2242PueAfipDesSinAc});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("PuestoAfip");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newpuestoafip");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A2213PueAfipCod = "" ;
      A2214PueAfipDes = "" ;
      A2241PueAfipGenDes = "" ;
      AV11PueAfipDesSinAc = "" ;
      GXv_char1 = new String[1] ;
      A2242PueAfipDesSinAc = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newpuestoafip__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int GX_INS279 ;
   private String AV8PueAfipCod ;
   private String A2213PueAfipCod ;
   private String GXv_char1[] ;
   private String Gx_emsg ;
   private String AV9PueAfipDes ;
   private String AV10PueAfipGenDes ;
   private String A2214PueAfipDes ;
   private String A2241PueAfipGenDes ;
   private String AV11PueAfipDesSinAc ;
   private String A2242PueAfipDesSinAc ;
   private IDataStoreProvider pr_default ;
}

final  class newpuestoafip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P028B2", "SAVEPOINT gxupdate;INSERT INTO PuestoAfip(PueAfipCod, PueAfipDes, PueAfipGenDes, PueAfipDesSinAc) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setString(1, (String)parms[0], 4);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               return;
      }
   }

}

