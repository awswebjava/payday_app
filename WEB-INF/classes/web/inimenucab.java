package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inimenucab extends GXProcedure
{
   public inimenucab( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inimenucab.class ), "" );
   }

   public inimenucab( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( byte aP0 ,
                        byte aP1 ,
                        short aP2 ,
                        long aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( byte aP0 ,
                             byte aP1 ,
                             short aP2 ,
                             long aP3 )
   {
      inimenucab.this.AV8RolId = aP0;
      inimenucab.this.AV9PerfilId = aP1;
      inimenucab.this.AV11MenuPais = aP2;
      inimenucab.this.AV10MenuVerId = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV17GXLvl4 = (byte)(0) ;
      /* Using cursor P01UH2 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV8RolId), Byte.valueOf(AV9PerfilId), Long.valueOf(AV10MenuVerId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1928MenuVerId = P01UH2_A1928MenuVerId[0] ;
         A1925PerfilId = P01UH2_A1925PerfilId[0] ;
         A1923RolId = P01UH2_A1923RolId[0] ;
         AV17GXLvl4 = (byte)(1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV17GXLvl4 == 0 )
      {
         /*
            INSERT RECORD ON TABLE MenuVersiones

         */
         A1923RolId = AV8RolId ;
         A1925PerfilId = AV9PerfilId ;
         A1928MenuVerId = AV10MenuVerId ;
         if ( ! (0==AV11MenuPais) )
         {
            A1927MenuPais = AV11MenuPais ;
            n1927MenuPais = false ;
         }
         else
         {
            A1927MenuPais = (short)(0) ;
            n1927MenuPais = false ;
            n1927MenuPais = true ;
         }
         /* Using cursor P01UH3 */
         pr_default.execute(1, new Object[] {Byte.valueOf(A1923RolId), Byte.valueOf(A1925PerfilId), Long.valueOf(A1928MenuVerId), Boolean.valueOf(n1927MenuPais), Short.valueOf(A1927MenuPais)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuVersiones");
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
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "inimenucab");
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
      P01UH2_A1928MenuVerId = new long[1] ;
      P01UH2_A1925PerfilId = new byte[1] ;
      P01UH2_A1923RolId = new byte[1] ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.inimenucab__default(),
         new Object[] {
             new Object[] {
            P01UH2_A1928MenuVerId, P01UH2_A1925PerfilId, P01UH2_A1923RolId
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8RolId ;
   private byte AV9PerfilId ;
   private byte AV17GXLvl4 ;
   private byte A1925PerfilId ;
   private byte A1923RolId ;
   private short AV11MenuPais ;
   private short A1927MenuPais ;
   private short Gx_err ;
   private int GX_INS255 ;
   private long AV10MenuVerId ;
   private long A1928MenuVerId ;
   private String scmdbuf ;
   private String Gx_emsg ;
   private boolean n1927MenuPais ;
   private IDataStoreProvider pr_default ;
   private long[] P01UH2_A1928MenuVerId ;
   private byte[] P01UH2_A1925PerfilId ;
   private byte[] P01UH2_A1923RolId ;
}

final  class inimenucab__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01UH2", "SELECT MenuVerId, PerfilId, RolId FROM MenuVersiones WHERE RolId = ? and PerfilId = ? and MenuVerId = ? ORDER BY RolId, PerfilId, MenuVerId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01UH3", "SAVEPOINT gxupdate;INSERT INTO MenuVersiones(RolId, PerfilId, MenuVerId, MenuPais) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
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
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
            case 1 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(4, ((Number) parms[4]).shortValue());
               }
               return;
      }
   }

}

