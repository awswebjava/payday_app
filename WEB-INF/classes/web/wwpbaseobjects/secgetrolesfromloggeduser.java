package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secgetrolesfromloggeduser extends GXProcedure
{
   public secgetrolesfromloggeduser( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secgetrolesfromloggeduser.class ), "" );
   }

   public secgetrolesfromloggeduser( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<Short> executeUdp( )
   {
      secgetrolesfromloggeduser.this.aP0 = new GXSimpleCollection[] {new GXSimpleCollection<Short>(Short.class, "internal", "")};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXSimpleCollection<Short>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXSimpleCollection<Short>[] aP0 )
   {
      secgetrolesfromloggeduser.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9SecRoleIdsXML = GXutil.trim( AV11WebSession.getValue("SecGetRolesFromLoggedUser")) ;
      if ( (GXutil.strcmp("", AV9SecRoleIdsXML)==0) )
      {
         AV8SecRoleIds = new GXSimpleCollection<Short>(Short.class, "internal", "") ;
         /* Using cursor P00BT2 */
         pr_default.execute(0, new Object[] {Short.valueOf(AV10SecUserId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A67SecUserId = P00BT2_A67SecUserId[0] ;
            A65SecRoleId = P00BT2_A65SecRoleId[0] ;
            AV8SecRoleIds.add((short)(A65SecRoleId), 0);
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV8SecRoleIds.size() > 0 )
         {
            AV9SecRoleIdsXML = AV8SecRoleIds.toxml(false, true, "Collection", "") ;
            AV11WebSession.setValue("SecGetRolesFromLoggedUser", AV9SecRoleIdsXML);
         }
      }
      else
      {
         AV8SecRoleIds.fromxml(AV9SecRoleIdsXML, null, null);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = secgetrolesfromloggeduser.this.AV8SecRoleIds;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8SecRoleIds = new GXSimpleCollection<Short>(Short.class, "internal", "");
      AV9SecRoleIdsXML = "" ;
      AV11WebSession = httpContext.getWebSession();
      scmdbuf = "" ;
      P00BT2_A67SecUserId = new short[1] ;
      P00BT2_A65SecRoleId = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.secgetrolesfromloggeduser__default(),
         new Object[] {
             new Object[] {
            P00BT2_A67SecUserId, P00BT2_A65SecRoleId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10SecUserId ;
   private short A67SecUserId ;
   private short A65SecRoleId ;
   private short Gx_err ;
   private String scmdbuf ;
   private String AV9SecRoleIdsXML ;
   private GXSimpleCollection<Short> AV8SecRoleIds ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private GXSimpleCollection<Short>[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P00BT2_A67SecUserId ;
   private short[] P00BT2_A65SecRoleId ;
}

final  class secgetrolesfromloggeduser__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00BT2", "SELECT SecUserId, SecRoleId FROM SecUserRole WHERE SecUserId = ? ORDER BY SecUserId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

