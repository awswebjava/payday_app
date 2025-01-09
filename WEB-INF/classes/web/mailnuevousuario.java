package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mailnuevousuario extends GXProcedure
{
   public mailnuevousuario( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mailnuevousuario.class ), "" );
   }

   public mailnuevousuario( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 ,
                        String aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             String aP1 )
   {
      mailnuevousuario.this.AV15SecUserId = aP0;
      mailnuevousuario.this.AV16BaseUrl = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&SecUserId ", "")+GXutil.str( AV15SecUserId, 4, 0)) ;
      AV20GXLvl2 = (byte)(0) ;
      /* Using cursor P00F02 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV15SecUserId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A67SecUserId = P00F02_A67SecUserId[0] ;
         A365SecParAct = P00F02_A365SecParAct[0] ;
         A68SecUserName = P00F02_A68SecUserName[0] ;
         A359SecUserPerName = P00F02_A359SecUserPerName[0] ;
         AV20GXLvl2 = (byte)(1) ;
         AV8Texto = httpContext.getMessage( "Active su <b>usuario</b> haciendo click en este link: ", "") ;
         AV14package = httpContext.getMessage( "com.a3lsueldos.", "") ;
         AV13link = GXutil.trim( AV16BaseUrl) + GXutil.trim( AV14package) + httpContext.getMessage( "activarusuario?", "") + GXutil.trim( A365SecParAct) ;
         new web.msgdebug(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&link ", "")+GXutil.trim( AV13link)) ;
         new web.msgdebug(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&BaseUrll ", "")+GXutil.trim( AV16BaseUrl)) ;
         AV8Texto += GXutil.trim( AV13link) ;
         new web.enviarmail(remoteHandle, context).execute( A68SecUserName, A359SecUserPerName, httpContext.getMessage( "Activación de Usuario", ""), AV8Texto, true) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV20GXLvl2 == 0 )
      {
         new web.msgdebug(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "none", "")) ;
      }
      if ( false )
      {
         callWebObject(formatLink("web.activarusuario", new String[] {GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"SecParAct"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19Pgmname = "" ;
      scmdbuf = "" ;
      P00F02_A67SecUserId = new short[1] ;
      P00F02_A365SecParAct = new String[] {""} ;
      P00F02_A68SecUserName = new String[] {""} ;
      P00F02_A359SecUserPerName = new String[] {""} ;
      A365SecParAct = "" ;
      A68SecUserName = "" ;
      A359SecUserPerName = "" ;
      AV8Texto = "" ;
      AV14package = "" ;
      AV13link = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.mailnuevousuario__default(),
         new Object[] {
             new Object[] {
            P00F02_A67SecUserId, P00F02_A365SecParAct, P00F02_A68SecUserName, P00F02_A359SecUserPerName
            }
         }
      );
      AV19Pgmname = "MailNuevoUsuario" ;
      /* GeneXus formulas. */
      AV19Pgmname = "MailNuevoUsuario" ;
      Gx_err = (short)(0) ;
   }

   private byte AV20GXLvl2 ;
   private short AV15SecUserId ;
   private short A67SecUserId ;
   private short Gx_err ;
   private String AV19Pgmname ;
   private String scmdbuf ;
   private String AV16BaseUrl ;
   private String A365SecParAct ;
   private String A68SecUserName ;
   private String A359SecUserPerName ;
   private String AV8Texto ;
   private String AV14package ;
   private String AV13link ;
   private IDataStoreProvider pr_default ;
   private short[] P00F02_A67SecUserId ;
   private String[] P00F02_A365SecParAct ;
   private String[] P00F02_A68SecUserName ;
   private String[] P00F02_A359SecUserPerName ;
}

final  class mailnuevousuario__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00F02", "SELECT SecUserId, SecParAct, SecUserName, SecUserPerName FROM SecUser WHERE SecUserId = ? ORDER BY SecUserId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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

