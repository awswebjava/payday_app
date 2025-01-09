package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ini_pais_estadosciviles extends GXProcedure
{
   public ini_pais_estadosciviles( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ini_pais_estadosciviles.class ), "" );
   }

   public ini_pais_estadosciviles( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( short aP0 )
   {
      ini_pais_estadosciviles.this.AV8PaiCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV11GXLvl1 = (byte)(0) ;
      /* Using cursor P01KB2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1748EstaCivilCod = P01KB2_A1748EstaCivilCod[0] ;
         AV11GXLvl1 = (byte)(1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV11GXLvl1 == 0 )
      {
         /*
            INSERT RECORD ON TABLE Estados_civiles

         */
         A1747EstaCivilPais = AV8PaiCod ;
         A1749EstaCivilDescrip = httpContext.getMessage( "Casado/Conviviendo", "") ;
         A1751EstaCivilDescripFem = httpContext.getMessage( "Casada/Conviviendo", "") ;
         A2093EstaCivilCodFor = httpContext.getMessage( "C", "") ;
         A2272EstaCivilCasadoEs = true ;
         /* Using cursor P01KB3 */
         pr_default.execute(1, new Object[] {Short.valueOf(A1747EstaCivilPais), A1749EstaCivilDescrip, A1751EstaCivilDescripFem, A2093EstaCivilCodFor, Boolean.valueOf(A2272EstaCivilCasadoEs)});
         /* Retrieving last key number assigned */
         /* Using cursor P01KB4 */
         pr_default.execute(2);
         A1748EstaCivilCod = P01KB4_A1748EstaCivilCod[0] ;
         pr_default.close(2);
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Estados_civiles");
         if ( (pr_default.getStatus(1) == 1) )
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
         /*
            INSERT RECORD ON TABLE Estados_civiles

         */
         A1747EstaCivilPais = AV8PaiCod ;
         A1749EstaCivilDescrip = httpContext.getMessage( "Soltero", "") ;
         A1751EstaCivilDescripFem = httpContext.getMessage( "Soltera", "") ;
         A2093EstaCivilCodFor = httpContext.getMessage( "S", "") ;
         A2272EstaCivilCasadoEs = false ;
         /* Using cursor P01KB5 */
         pr_default.execute(3, new Object[] {Short.valueOf(A1747EstaCivilPais), A1749EstaCivilDescrip, A1751EstaCivilDescripFem, A2093EstaCivilCodFor, Boolean.valueOf(A2272EstaCivilCasadoEs)});
         /* Retrieving last key number assigned */
         /* Using cursor P01KB6 */
         pr_default.execute(4);
         A1748EstaCivilCod = P01KB6_A1748EstaCivilCod[0] ;
         pr_default.close(4);
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Estados_civiles");
         if ( (pr_default.getStatus(3) == 1) )
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
         /*
            INSERT RECORD ON TABLE Estados_civiles

         */
         A1747EstaCivilPais = AV8PaiCod ;
         A1749EstaCivilDescrip = httpContext.getMessage( "Otro", "") ;
         A1751EstaCivilDescripFem = httpContext.getMessage( "Otro", "") ;
         A2093EstaCivilCodFor = httpContext.getMessage( "O", "") ;
         A2272EstaCivilCasadoEs = false ;
         /* Using cursor P01KB7 */
         pr_default.execute(5, new Object[] {Short.valueOf(A1747EstaCivilPais), A1749EstaCivilDescrip, A1751EstaCivilDescripFem, A2093EstaCivilCodFor, Boolean.valueOf(A2272EstaCivilCasadoEs)});
         /* Retrieving last key number assigned */
         /* Using cursor P01KB8 */
         pr_default.execute(6);
         A1748EstaCivilCod = P01KB8_A1748EstaCivilCod[0] ;
         pr_default.close(6);
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Estados_civiles");
         if ( (pr_default.getStatus(5) == 1) )
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
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "ini_pais_estadosciviles");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P01KB2_A1748EstaCivilCod = new short[1] ;
      A1749EstaCivilDescrip = "" ;
      A1751EstaCivilDescripFem = "" ;
      A2093EstaCivilCodFor = "" ;
      P01KB4_A1748EstaCivilCod = new short[1] ;
      Gx_emsg = "" ;
      P01KB6_A1748EstaCivilCod = new short[1] ;
      P01KB8_A1748EstaCivilCod = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ini_pais_estadosciviles__default(),
         new Object[] {
             new Object[] {
            P01KB2_A1748EstaCivilCod
            }
            , new Object[] {
            }
            , new Object[] {
            P01KB4_A1748EstaCivilCod
            }
            , new Object[] {
            }
            , new Object[] {
            P01KB6_A1748EstaCivilCod
            }
            , new Object[] {
            }
            , new Object[] {
            P01KB8_A1748EstaCivilCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV11GXLvl1 ;
   private short AV8PaiCod ;
   private short A1748EstaCivilCod ;
   private short A1747EstaCivilPais ;
   private short Gx_err ;
   private int GX_INS236 ;
   private String scmdbuf ;
   private String A2093EstaCivilCodFor ;
   private String Gx_emsg ;
   private boolean A2272EstaCivilCasadoEs ;
   private String A1749EstaCivilDescrip ;
   private String A1751EstaCivilDescripFem ;
   private IDataStoreProvider pr_default ;
   private short[] P01KB2_A1748EstaCivilCod ;
   private short[] P01KB4_A1748EstaCivilCod ;
   private short[] P01KB6_A1748EstaCivilCod ;
   private short[] P01KB8_A1748EstaCivilCod ;
}

final  class ini_pais_estadosciviles__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01KB2", "SELECT EstaCivilCod FROM Estados_civiles ORDER BY EstaCivilCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01KB3", "SAVEPOINT gxupdate;INSERT INTO Estados_civiles(EstaCivilPais, EstaCivilDescrip, EstaCivilDescripFem, EstaCivilCodFor, EstaCivilCasadoEs) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01KB4", "SELECT currval('EstaCivilCod') ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01KB5", "SAVEPOINT gxupdate;INSERT INTO Estados_civiles(EstaCivilPais, EstaCivilDescrip, EstaCivilDescripFem, EstaCivilCodFor, EstaCivilCasadoEs) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01KB6", "SELECT currval('EstaCivilCod') ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01KB7", "SAVEPOINT gxupdate;INSERT INTO Estados_civiles(EstaCivilPais, EstaCivilDescrip, EstaCivilDescripFem, EstaCivilCodFor, EstaCivilCasadoEs) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01KB8", "SELECT currval('EstaCivilCod') ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 30, false);
               stmt.setVarchar(3, (String)parms[2], 30, false);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 30, false);
               stmt.setVarchar(3, (String)parms[2], 30, false);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 30, false);
               stmt.setVarchar(3, (String)parms[2], 30, false);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               return;
      }
   }

}

