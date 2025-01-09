package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secisauthbyfunctionalityid extends GXProcedure
{
   public secisauthbyfunctionalityid( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secisauthbyfunctionalityid.class ), "" );
   }

   public secisauthbyfunctionalityid( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( long aP0 )
   {
      secisauthbyfunctionalityid.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( long aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( long aP0 ,
                             boolean[] aP1 )
   {
      secisauthbyfunctionalityid.this.AV13SecFunctionalityId = aP0;
      secisauthbyfunctionalityid.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10IsAuthorized = false ;
      GXt_objcol_int1 = AV9SecRolIds ;
      GXv_objcol_int2[0] = GXt_objcol_int1 ;
      new web.wwpbaseobjects.secgetrolesfromloggeduser(remoteHandle, context).execute( GXv_objcol_int2) ;
      GXt_objcol_int1 = GXv_objcol_int2[0] ;
      AV9SecRolIds = GXt_objcol_int1 ;
      AV16GXV1 = 1 ;
      while ( AV16GXV1 <= AV9SecRolIds.size() )
      {
         AV12SecRolId = ((Number) AV9SecRolIds.elementAt(-1+AV16GXV1)).shortValue() ;
         /* Using cursor P00BN2 */
         pr_default.execute(0, new Object[] {Long.valueOf(AV13SecFunctionalityId), Short.valueOf(AV12SecRolId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A62SecFunctionalityId = P00BN2_A62SecFunctionalityId[0] ;
            A65SecRoleId = P00BN2_A65SecRoleId[0] ;
            AV10IsAuthorized = true ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         if ( AV10IsAuthorized )
         {
            if (true) break;
         }
         AV16GXV1 = (int)(AV16GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = secisauthbyfunctionalityid.this.AV10IsAuthorized;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9SecRolIds = new GXSimpleCollection<Short>(Short.class, "internal", "");
      GXt_objcol_int1 = new GXSimpleCollection<Short>(Short.class, "internal", "");
      GXv_objcol_int2 = new GXSimpleCollection[1] ;
      scmdbuf = "" ;
      P00BN2_A62SecFunctionalityId = new long[1] ;
      P00BN2_A65SecRoleId = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.secisauthbyfunctionalityid__default(),
         new Object[] {
             new Object[] {
            P00BN2_A62SecFunctionalityId, P00BN2_A65SecRoleId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12SecRolId ;
   private short A65SecRoleId ;
   private short Gx_err ;
   private int AV16GXV1 ;
   private long AV13SecFunctionalityId ;
   private long A62SecFunctionalityId ;
   private String scmdbuf ;
   private boolean AV10IsAuthorized ;
   private GXSimpleCollection<Short> AV9SecRolIds ;
   private GXSimpleCollection<Short> GXt_objcol_int1 ;
   private GXSimpleCollection<Short> GXv_objcol_int2[] ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private long[] P00BN2_A62SecFunctionalityId ;
   private short[] P00BN2_A65SecRoleId ;
}

final  class secisauthbyfunctionalityid__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00BN2", "SELECT SecFunctionalityId, SecRoleId FROM SecFunctionalityRole WHERE SecFunctionalityId = ? and SecRoleId = ? ORDER BY SecFunctionalityId, SecRoleId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
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
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

