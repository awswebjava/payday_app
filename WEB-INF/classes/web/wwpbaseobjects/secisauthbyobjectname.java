package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secisauthbyobjectname extends GXProcedure
{
   public secisauthbyobjectname( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secisauthbyobjectname.class ), "" );
   }

   public secisauthbyobjectname( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 )
   {
      secisauthbyobjectname.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             boolean[] aP1 )
   {
      secisauthbyobjectname.this.AV9SecObjectName = aP0;
      secisauthbyobjectname.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8IsAuthorized = false ;
      AV10LowerSecObjectName = GXutil.trim( GXutil.lower( AV9SecObjectName)) ;
      AV13GXLvl4 = (byte)(0) ;
      /* Using cursor P000I2 */
      pr_default.execute(0, new Object[] {AV10LowerSecObjectName});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A66SecObjectName = P000I2_A66SecObjectName[0] ;
         A62SecFunctionalityId = P000I2_A62SecFunctionalityId[0] ;
         AV13GXLvl4 = (byte)(1) ;
         GXt_boolean1 = AV8IsAuthorized ;
         GXv_boolean2[0] = GXt_boolean1 ;
         new web.wwpbaseobjects.secisauthbyfunctionalityid(remoteHandle, context).execute( A62SecFunctionalityId, GXv_boolean2) ;
         secisauthbyobjectname.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( AV8IsAuthorized )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV13GXLvl4 == 0 )
      {
         AV8IsAuthorized = true ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "&IsAuthorized ", "")+GXutil.trim( GXutil.booltostr( AV8IsAuthorized))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = secisauthbyobjectname.this.AV8IsAuthorized;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10LowerSecObjectName = "" ;
      scmdbuf = "" ;
      P000I2_A66SecObjectName = new String[] {""} ;
      P000I2_A62SecFunctionalityId = new long[1] ;
      A66SecObjectName = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV14Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.secisauthbyobjectname__default(),
         new Object[] {
             new Object[] {
            P000I2_A66SecObjectName, P000I2_A62SecFunctionalityId
            }
         }
      );
      AV14Pgmname = "WWPBaseObjects.SecIsAuthByObjectName" ;
      /* GeneXus formulas. */
      AV14Pgmname = "WWPBaseObjects.SecIsAuthByObjectName" ;
      Gx_err = (short)(0) ;
   }

   private byte AV13GXLvl4 ;
   private short Gx_err ;
   private long A62SecFunctionalityId ;
   private String scmdbuf ;
   private String AV14Pgmname ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private String AV9SecObjectName ;
   private String AV10LowerSecObjectName ;
   private String A66SecObjectName ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P000I2_A66SecObjectName ;
   private long[] P000I2_A62SecFunctionalityId ;
}

final  class secisauthbyobjectname__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000I2", "SELECT SecObjectName, SecFunctionalityId FROM SecObjectFunctionalities WHERE SecObjectName = ( ?) ORDER BY SecObjectName ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((long[]) buf[1])[0] = rslt.getLong(2);
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
               stmt.setVarchar(1, (String)parms[0], 120);
               return;
      }
   }

}

