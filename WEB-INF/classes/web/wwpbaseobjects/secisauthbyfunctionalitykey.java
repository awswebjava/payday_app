package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secisauthbyfunctionalitykey extends GXProcedure
{
   public secisauthbyfunctionalitykey( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secisauthbyfunctionalitykey.class ), "" );
   }

   public secisauthbyfunctionalitykey( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 )
   {
      secisauthbyfunctionalitykey.this.aP1 = new boolean[] {false};
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
      secisauthbyfunctionalitykey.this.AV10parm_SecFunctionalityKey = aP0;
      secisauthbyfunctionalitykey.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV20CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      secisauthbyfunctionalitykey.this.GXt_int1 = GXv_int2[0] ;
      AV20CliCod = GXt_int1 ;
      GXv_char3[0] = AV23parmvalue ;
      new web.getparametro(remoteHandle, context).execute( AV20CliCod, new web.autorizartodo_codigoparam(remoteHandle, context).executeUdp( ), GXv_char3) ;
      secisauthbyfunctionalitykey.this.AV23parmvalue = GXv_char3[0] ;
      AV22autorizarTodo = GXutil.boolval( AV23parmvalue) ;
      if ( AV22autorizarTodo )
      {
         AV8IsAuthorized = true ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_int4 = AV15SecUserId ;
      GXv_int5[0] = GXt_int4 ;
      new web.getusuloggedid(remoteHandle, context).execute( GXv_int5) ;
      secisauthbyfunctionalitykey.this.GXt_int4 = GXv_int5[0] ;
      AV15SecUserId = GXt_int4 ;
      GXv_int6[0] = AV14RolId ;
      GXv_int7[0] = AV13PerfilId ;
      GXv_int8[0] = AV12MenuVerId ;
      new web.getusumenu(remoteHandle, context).execute( AV15SecUserId, GXv_int6, GXv_int7, GXv_int8) ;
      secisauthbyfunctionalitykey.this.AV14RolId = GXv_int6[0] ;
      secisauthbyfunctionalitykey.this.AV13PerfilId = GXv_int7[0] ;
      secisauthbyfunctionalitykey.this.AV12MenuVerId = GXv_int8[0] ;
      if ( ( GXutil.strcmp(AV10parm_SecFunctionalityKey, httpContext.getMessage( "WWP_MasterPageTopActionsWC", "")) == 0 ) || ( GXutil.strcmp(AV10parm_SecFunctionalityKey, httpContext.getMessage( "NotAuthorized", "")) == 0 ) )
      {
         AV8IsAuthorized = true ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      else
      {
         if ( ( GXutil.strcmp(AV10parm_SecFunctionalityKey, httpContext.getMessage( "Pruebas", "")) == 0 ) && ( AV14RolId == 1 ) )
         {
            AV8IsAuthorized = true ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         else
         {
            if ( ( GXutil.strcmp(AV10parm_SecFunctionalityKey, httpContext.getMessage( "Pruebas", "")) == 0 ) && ( AV14RolId == 2 ) )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      GXv_char3[0] = AV16MenuOpcObj ;
      GXv_char9[0] = AV11MenuOpcAcc ;
      new web.getmenuobjporpgm(remoteHandle, context).execute( AV10parm_SecFunctionalityKey, GXv_char3, GXv_char9) ;
      secisauthbyfunctionalitykey.this.AV16MenuOpcObj = GXv_char3[0] ;
      secisauthbyfunctionalitykey.this.AV11MenuOpcAcc = GXv_char9[0] ;
      AV26GXLvl41 = (byte)(0) ;
      /* Using cursor P000G2 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV14RolId), Byte.valueOf(AV13PerfilId), Long.valueOf(AV12MenuVerId), AV16MenuOpcObj});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1929MenuOpcCod = P000G2_A1929MenuOpcCod[0] ;
         A1928MenuVerId = P000G2_A1928MenuVerId[0] ;
         A1925PerfilId = P000G2_A1925PerfilId[0] ;
         A1923RolId = P000G2_A1923RolId[0] ;
         A2361MenuOpcObj = P000G2_A2361MenuOpcObj[0] ;
         AV26GXLvl41 = (byte)(1) ;
         AV27GXLvl48 = (byte)(0) ;
         /* Using cursor P000G3 */
         pr_default.execute(1, new Object[] {Byte.valueOf(A1923RolId), Byte.valueOf(A1925PerfilId), Long.valueOf(A1928MenuVerId), A1929MenuOpcCod, AV11MenuOpcAcc});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A2365MenuOpcAcc = P000G3_A2365MenuOpcAcc[0] ;
            AV27GXLvl48 = (byte)(1) ;
            AV8IsAuthorized = true ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         if ( AV27GXLvl48 == 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV20CliCod, AV28Pgmname, httpContext.getMessage( "no autorizado &MenuOpcObj ", "")+GXutil.trim( AV16MenuOpcObj)+httpContext.getMessage( " &MenuOpcAcc ", "")+GXutil.trim( AV11MenuOpcAcc)) ;
         }
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV26GXLvl41 == 0 )
      {
         /* Execute user subroutine: 'EXISTE EN ALGUN PERFIL' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( ! AV21existe )
         {
            AV8IsAuthorized = true ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV20CliCod, AV28Pgmname, httpContext.getMessage( "autoriza por no estar definido", "")) ;
         }
         else
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV20CliCod, AV28Pgmname, httpContext.getMessage( "no autorizado &MenuOpcObj por no existir en rol", "")) ;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'EXISTE EN ALGUN PERFIL' Routine */
      returnInSub = false ;
      /* Using cursor P000G4 */
      pr_default.execute(2, new Object[] {AV16MenuOpcObj});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A2361MenuOpcObj = P000G4_A2361MenuOpcObj[0] ;
         A1923RolId = P000G4_A1923RolId[0] ;
         A1925PerfilId = P000G4_A1925PerfilId[0] ;
         A1928MenuVerId = P000G4_A1928MenuVerId[0] ;
         A1929MenuOpcCod = P000G4_A1929MenuOpcCod[0] ;
         AV21existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(2);
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP1[0] = secisauthbyfunctionalitykey.this.AV8IsAuthorized;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new int[1] ;
      AV23parmvalue = "" ;
      GXv_int5 = new short[1] ;
      GXv_int6 = new byte[1] ;
      GXv_int7 = new byte[1] ;
      GXv_int8 = new long[1] ;
      AV16MenuOpcObj = "" ;
      GXv_char3 = new String[1] ;
      AV11MenuOpcAcc = "" ;
      GXv_char9 = new String[1] ;
      scmdbuf = "" ;
      P000G2_A1929MenuOpcCod = new String[] {""} ;
      P000G2_A1928MenuVerId = new long[1] ;
      P000G2_A1925PerfilId = new byte[1] ;
      P000G2_A1923RolId = new byte[1] ;
      P000G2_A2361MenuOpcObj = new String[] {""} ;
      A1929MenuOpcCod = "" ;
      A2361MenuOpcObj = "" ;
      P000G3_A1923RolId = new byte[1] ;
      P000G3_A1925PerfilId = new byte[1] ;
      P000G3_A1928MenuVerId = new long[1] ;
      P000G3_A1929MenuOpcCod = new String[] {""} ;
      P000G3_A2365MenuOpcAcc = new String[] {""} ;
      A2365MenuOpcAcc = "" ;
      AV28Pgmname = "" ;
      P000G4_A2361MenuOpcObj = new String[] {""} ;
      P000G4_A1923RolId = new byte[1] ;
      P000G4_A1925PerfilId = new byte[1] ;
      P000G4_A1928MenuVerId = new long[1] ;
      P000G4_A1929MenuOpcCod = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.secisauthbyfunctionalitykey__default(),
         new Object[] {
             new Object[] {
            P000G2_A1929MenuOpcCod, P000G2_A1928MenuVerId, P000G2_A1925PerfilId, P000G2_A1923RolId, P000G2_A2361MenuOpcObj
            }
            , new Object[] {
            P000G3_A1923RolId, P000G3_A1925PerfilId, P000G3_A1928MenuVerId, P000G3_A1929MenuOpcCod, P000G3_A2365MenuOpcAcc
            }
            , new Object[] {
            P000G4_A2361MenuOpcObj, P000G4_A1923RolId, P000G4_A1925PerfilId, P000G4_A1928MenuVerId, P000G4_A1929MenuOpcCod
            }
         }
      );
      AV28Pgmname = "WWPBaseObjects.SecIsAuthByFunctionalityKey" ;
      /* GeneXus formulas. */
      AV28Pgmname = "WWPBaseObjects.SecIsAuthByFunctionalityKey" ;
      Gx_err = (short)(0) ;
   }

   private byte AV14RolId ;
   private byte GXv_int6[] ;
   private byte AV13PerfilId ;
   private byte GXv_int7[] ;
   private byte AV26GXLvl41 ;
   private byte A1925PerfilId ;
   private byte A1923RolId ;
   private byte AV27GXLvl48 ;
   private short AV15SecUserId ;
   private short GXt_int4 ;
   private short GXv_int5[] ;
   private short Gx_err ;
   private int AV20CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private long AV12MenuVerId ;
   private long GXv_int8[] ;
   private long A1928MenuVerId ;
   private String AV16MenuOpcObj ;
   private String GXv_char3[] ;
   private String AV11MenuOpcAcc ;
   private String GXv_char9[] ;
   private String scmdbuf ;
   private String A2361MenuOpcObj ;
   private String A2365MenuOpcAcc ;
   private String AV28Pgmname ;
   private boolean AV8IsAuthorized ;
   private boolean AV22autorizarTodo ;
   private boolean returnInSub ;
   private boolean AV21existe ;
   private String AV23parmvalue ;
   private String AV10parm_SecFunctionalityKey ;
   private String A1929MenuOpcCod ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P000G2_A1929MenuOpcCod ;
   private long[] P000G2_A1928MenuVerId ;
   private byte[] P000G2_A1925PerfilId ;
   private byte[] P000G2_A1923RolId ;
   private String[] P000G2_A2361MenuOpcObj ;
   private byte[] P000G3_A1923RolId ;
   private byte[] P000G3_A1925PerfilId ;
   private long[] P000G3_A1928MenuVerId ;
   private String[] P000G3_A1929MenuOpcCod ;
   private String[] P000G3_A2365MenuOpcAcc ;
   private String[] P000G4_A2361MenuOpcObj ;
   private byte[] P000G4_A1923RolId ;
   private byte[] P000G4_A1925PerfilId ;
   private long[] P000G4_A1928MenuVerId ;
   private String[] P000G4_A1929MenuOpcCod ;
}

final  class secisauthbyfunctionalitykey__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000G2", "SELECT MenuOpcCod, MenuVerId, PerfilId, RolId, MenuOpcObj FROM MenuVersionesOpciones WHERE (RolId = ? and PerfilId = ? and MenuVerId = ?) AND (MenuOpcObj = ( ?)) ORDER BY RolId, PerfilId, MenuVerId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P000G3", "SELECT RolId, PerfilId, MenuVerId, MenuOpcCod, MenuOpcAcc FROM MenuVerOpcPermisos WHERE RolId = ? and PerfilId = ? and MenuVerId = ? and MenuOpcCod = ( ?) and MenuOpcAcc = ( ?) ORDER BY RolId, PerfilId, MenuVerId, MenuOpcCod, MenuOpcAcc ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P000G4", "SELECT MenuOpcObj, RolId, PerfilId, MenuVerId, MenuOpcCod FROM MenuVersionesOpciones WHERE MenuOpcObj = ( ?) ORDER BY RolId, PerfilId, MenuVerId, MenuOpcCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 128);
               return;
            case 1 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 128);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
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
               stmt.setString(4, (String)parms[3], 128);
               return;
            case 1 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setVarchar(4, (String)parms[3], 100, false);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 128);
               return;
      }
   }

}

