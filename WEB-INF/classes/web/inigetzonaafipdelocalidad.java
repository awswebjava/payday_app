package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inigetzonaafipdelocalidad extends GXProcedure
{
   public inigetzonaafipdelocalidad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inigetzonaafipdelocalidad.class ), "" );
   }

   public inigetzonaafipdelocalidad( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 ,
                             short aP1 ,
                             String aP2 )
   {
      inigetzonaafipdelocalidad.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( short aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( short aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String[] aP3 )
   {
      inigetzonaafipdelocalidad.this.AV12PaiCod = aP0;
      inigetzonaafipdelocalidad.this.AV9ProvCod = aP1;
      inigetzonaafipdelocalidad.this.AV13PARMLocNom = aP2;
      inigetzonaafipdelocalidad.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV10ProvNom ;
      new web.getprovincia(remoteHandle, context).execute( AV12PaiCod, AV9ProvCod, GXv_char1) ;
      inigetzonaafipdelocalidad.this.AV10ProvNom = GXv_char1[0] ;
      GXv_char1[0] = AV11LocNom ;
      new web.sacaracentos2(remoteHandle, context).execute( AV13PARMLocNom, GXv_char1) ;
      inigetzonaafipdelocalidad.this.AV11LocNom = GXv_char1[0] ;
      AV11LocNom = GXutil.upper( AV11LocNom) ;
      lV11LocNom = GXutil.concat( GXutil.rtrim( AV11LocNom), "%", "") ;
      /* Using cursor P02512 */
      pr_default.execute(0, new Object[] {AV10ProvNom, lV11LocNom});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A678ZonDescripSinAc = P02512_A678ZonDescripSinAc[0] ;
         A589ZonProvincia = P02512_A589ZonProvincia[0] ;
         A20ZonCod = P02512_A20ZonCod[0] ;
         AV8ZonCod = A20ZonCod ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( (GXutil.strcmp("", AV8ZonCod)==0) )
      {
         /* Using cursor P02513 */
         pr_default.execute(1, new Object[] {AV10ProvNom});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A2223ZonLocEs = P02513_A2223ZonLocEs[0] ;
            A589ZonProvincia = P02513_A589ZonProvincia[0] ;
            A20ZonCod = P02513_A20ZonCod[0] ;
            AV8ZonCod = A20ZonCod ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(1);
         }
         pr_default.close(1);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = inigetzonaafipdelocalidad.this.AV8ZonCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ZonCod = "" ;
      AV10ProvNom = "" ;
      AV11LocNom = "" ;
      GXv_char1 = new String[1] ;
      lV11LocNom = "" ;
      scmdbuf = "" ;
      P02512_A678ZonDescripSinAc = new String[] {""} ;
      P02512_A589ZonProvincia = new String[] {""} ;
      P02512_A20ZonCod = new String[] {""} ;
      A678ZonDescripSinAc = "" ;
      A589ZonProvincia = "" ;
      A20ZonCod = "" ;
      P02513_A2223ZonLocEs = new boolean[] {false} ;
      P02513_A589ZonProvincia = new String[] {""} ;
      P02513_A20ZonCod = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.inigetzonaafipdelocalidad__default(),
         new Object[] {
             new Object[] {
            P02512_A678ZonDescripSinAc, P02512_A589ZonProvincia, P02512_A20ZonCod
            }
            , new Object[] {
            P02513_A2223ZonLocEs, P02513_A589ZonProvincia, P02513_A20ZonCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12PaiCod ;
   private short AV9ProvCod ;
   private short Gx_err ;
   private String AV8ZonCod ;
   private String GXv_char1[] ;
   private String scmdbuf ;
   private String A20ZonCod ;
   private boolean A2223ZonLocEs ;
   private String AV13PARMLocNom ;
   private String AV10ProvNom ;
   private String AV11LocNom ;
   private String lV11LocNom ;
   private String A678ZonDescripSinAc ;
   private String A589ZonProvincia ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P02512_A678ZonDescripSinAc ;
   private String[] P02512_A589ZonProvincia ;
   private String[] P02512_A20ZonCod ;
   private boolean[] P02513_A2223ZonLocEs ;
   private String[] P02513_A589ZonProvincia ;
   private String[] P02513_A20ZonCod ;
}

final  class inigetzonaafipdelocalidad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02512", "SELECT ZonDescripSinAc, ZonProvincia, ZonCod FROM Zona WHERE (RTRIM(LTRIM(UPPER(ZonProvincia))) = ( RTRIM(LTRIM(UPPER(?))))) AND (RTRIM(LTRIM(UPPER(ZonDescripSinAc))) like '%' || RTRIM(LTRIM(UPPER(?)))) ORDER BY ZonCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P02513", "SELECT ZonLocEs, ZonProvincia, ZonCod FROM Zona WHERE (RTRIM(LTRIM(UPPER(ZonProvincia))) = ( RTRIM(LTRIM(UPPER(?))))) AND (ZonLocEs = FALSE) ORDER BY ZonCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 1 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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
               stmt.setVarchar(1, (String)parms[0], 400);
               stmt.setVarchar(2, (String)parms[1], 40);
               return;
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 400);
               return;
      }
   }

}

