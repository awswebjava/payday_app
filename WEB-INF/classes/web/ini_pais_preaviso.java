package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ini_pais_preaviso extends GXProcedure
{
   public ini_pais_preaviso( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ini_pais_preaviso.class ), "" );
   }

   public ini_pais_preaviso( int remoteHandle ,
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
      ini_pais_preaviso.this.AV8PaiCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE Paispreaviso

      */
      A46PaiCod = AV8PaiCod ;
      A1535PaiAntMayCant = (byte)(0) ;
      A1536PaiAntMayDur = "meses" ;
      A1537PaiPreAviCant = (byte)(15) ;
      A1538PaiPreAviDur = "dias" ;
      /* Using cursor P01HR2 */
      pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1535PaiAntMayCant), A1536PaiAntMayDur, Byte.valueOf(A1537PaiPreAviCant), A1538PaiPreAviDur});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Paispreaviso");
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
      /*
         INSERT RECORD ON TABLE Paispreaviso

      */
      A46PaiCod = AV8PaiCod ;
      A1535PaiAntMayCant = (byte)(3) ;
      A1536PaiAntMayDur = "meses" ;
      A1537PaiPreAviCant = (byte)(1) ;
      A1538PaiPreAviDur = "meses" ;
      /* Using cursor P01HR3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1535PaiAntMayCant), A1536PaiAntMayDur, Byte.valueOf(A1537PaiPreAviCant), A1538PaiPreAviDur});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Paispreaviso");
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
         INSERT RECORD ON TABLE Paispreaviso

      */
      A46PaiCod = AV8PaiCod ;
      A1535PaiAntMayCant = (byte)(5) ;
      A1536PaiAntMayDur = "años" ;
      A1537PaiPreAviCant = (byte)(2) ;
      A1538PaiPreAviDur = "meses" ;
      /* Using cursor P01HR4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A46PaiCod), Byte.valueOf(A1535PaiAntMayCant), A1536PaiAntMayDur, Byte.valueOf(A1537PaiPreAviCant), A1538PaiPreAviDur});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Paispreaviso");
      if ( (pr_default.getStatus(2) == 1) )
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
      Application.commitDataStores(context, remoteHandle, pr_default, "ini_pais_preaviso");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A1536PaiAntMayDur = "" ;
      A1538PaiPreAviDur = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ini_pais_preaviso__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1535PaiAntMayCant ;
   private byte A1537PaiPreAviCant ;
   private short AV8PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int GX_INS196 ;
   private String A1536PaiAntMayDur ;
   private String A1538PaiPreAviDur ;
   private String Gx_emsg ;
   private IDataStoreProvider pr_default ;
}

final  class ini_pais_preaviso__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01HR2", "SAVEPOINT gxupdate;INSERT INTO Paispreaviso(PaiCod, PaiAntMayCant, PaiAntMayDur, PaiPreAviCant, PaiPreAviDur) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HR3", "SAVEPOINT gxupdate;INSERT INTO Paispreaviso(PaiCod, PaiAntMayCant, PaiAntMayDur, PaiPreAviCant, PaiPreAviDur) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HR4", "SAVEPOINT gxupdate;INSERT INTO Paispreaviso(PaiCod, PaiAntMayCant, PaiAntMayDur, PaiPreAviCant, PaiPreAviDur) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 20);
               return;
      }
   }

}

