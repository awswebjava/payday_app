package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ini_pais_sexos extends GXProcedure
{
   public ini_pais_sexos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ini_pais_sexos.class ), "" );
   }

   public ini_pais_sexos( int remoteHandle ,
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
      ini_pais_sexos.this.AV8PaiCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV11GXLvl1 = (byte)(0) ;
      /* Using cursor P01KA2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1743SexoId = P01KA2_A1743SexoId[0] ;
         AV11GXLvl1 = (byte)(1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV11GXLvl1 == 0 )
      {
         /*
            INSERT RECORD ON TABLE Sexos

         */
         A1742SexoPaiCod = AV8PaiCod ;
         A1744SexoNombre = httpContext.getMessage( "Masculino", "") ;
         A1745SexoBiologico = "macho" ;
         n1745SexoBiologico = false ;
         A1746SexoIdentidad = "macho" ;
         A2092SexoCodFor = httpContext.getMessage( "M", "") ;
         /* Using cursor P01KA3 */
         pr_default.execute(1, new Object[] {Short.valueOf(A1742SexoPaiCod), A1744SexoNombre, Boolean.valueOf(n1745SexoBiologico), A1745SexoBiologico, A1746SexoIdentidad, A2092SexoCodFor});
         /* Retrieving last key number assigned */
         /* Using cursor P01KA4 */
         pr_default.execute(2);
         A1743SexoId = P01KA4_A1743SexoId[0] ;
         pr_default.close(2);
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Sexos");
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
            INSERT RECORD ON TABLE Sexos

         */
         A1742SexoPaiCod = AV8PaiCod ;
         A1744SexoNombre = httpContext.getMessage( "Femenino", "") ;
         A1745SexoBiologico = "hembra" ;
         n1745SexoBiologico = false ;
         A1746SexoIdentidad = "hembra" ;
         A2092SexoCodFor = httpContext.getMessage( "F", "") ;
         /* Using cursor P01KA5 */
         pr_default.execute(3, new Object[] {Short.valueOf(A1742SexoPaiCod), A1744SexoNombre, Boolean.valueOf(n1745SexoBiologico), A1745SexoBiologico, A1746SexoIdentidad, A2092SexoCodFor});
         /* Retrieving last key number assigned */
         /* Using cursor P01KA6 */
         pr_default.execute(4);
         A1743SexoId = P01KA6_A1743SexoId[0] ;
         pr_default.close(4);
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Sexos");
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
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "ini_pais_sexos");
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
      P01KA2_A1743SexoId = new byte[1] ;
      A1744SexoNombre = "" ;
      A1745SexoBiologico = "" ;
      A1746SexoIdentidad = "" ;
      A2092SexoCodFor = "" ;
      P01KA4_A1743SexoId = new byte[1] ;
      Gx_emsg = "" ;
      P01KA6_A1743SexoId = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ini_pais_sexos__default(),
         new Object[] {
             new Object[] {
            P01KA2_A1743SexoId
            }
            , new Object[] {
            }
            , new Object[] {
            P01KA4_A1743SexoId
            }
            , new Object[] {
            }
            , new Object[] {
            P01KA6_A1743SexoId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV11GXLvl1 ;
   private byte A1743SexoId ;
   private short AV8PaiCod ;
   private short A1742SexoPaiCod ;
   private short Gx_err ;
   private int GX_INS235 ;
   private String scmdbuf ;
   private String A1745SexoBiologico ;
   private String A1746SexoIdentidad ;
   private String A2092SexoCodFor ;
   private String Gx_emsg ;
   private boolean n1745SexoBiologico ;
   private String A1744SexoNombre ;
   private IDataStoreProvider pr_default ;
   private byte[] P01KA2_A1743SexoId ;
   private byte[] P01KA4_A1743SexoId ;
   private byte[] P01KA6_A1743SexoId ;
}

final  class ini_pais_sexos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01KA2", "SELECT SexoId FROM Sexos ORDER BY SexoId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01KA3", "SAVEPOINT gxupdate;INSERT INTO Sexos(SexoPaiCod, SexoNombre, SexoBiologico, SexoIdentidad, SexoCodFor) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01KA4", "SELECT currval('SexoId') ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01KA5", "SAVEPOINT gxupdate;INSERT INTO Sexos(SexoPaiCod, SexoNombre, SexoBiologico, SexoIdentidad, SexoCodFor) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01KA6", "SELECT currval('SexoId') ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 2 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               return;
            case 4 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
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
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 20);
               }
               stmt.setString(4, (String)parms[4], 20);
               stmt.setString(5, (String)parms[5], 20);
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 30, false);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 20);
               }
               stmt.setString(4, (String)parms[4], 20);
               stmt.setString(5, (String)parms[5], 20);
               return;
      }
   }

}

