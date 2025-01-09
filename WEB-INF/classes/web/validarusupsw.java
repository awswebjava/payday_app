package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class validarusupsw extends GXProcedure
{
   public validarusupsw( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( validarusupsw.class ), "" );
   }

   public validarusupsw( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( String aP0 ,
                          String aP1 ,
                          boolean[] aP2 ,
                          boolean[] aP3 )
   {
      validarusupsw.this.aP4 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean[] aP2 ,
                        boolean[] aP3 ,
                        int[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean[] aP2 ,
                             boolean[] aP3 ,
                             int[] aP4 )
   {
      validarusupsw.this.AV8SecUserName = aP0;
      validarusupsw.this.AV9SecUserPassword = aP1;
      validarusupsw.this.aP2 = aP2;
      validarusupsw.this.aP3 = aP3;
      validarusupsw.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV19GXLvl3 = (byte)(0) ;
      /* Using cursor P02JZ2 */
      pr_default.execute(0, new Object[] {AV8SecUserName});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A364SecUsuActivo = P02JZ2_A364SecUsuActivo[0] ;
         A68SecUserName = P02JZ2_A68SecUserName[0] ;
         A67SecUserId = P02JZ2_A67SecUserId[0] ;
         A2388SecUserSal = P02JZ2_A2388SecUserSal[0] ;
         A356SecUserPassword = P02JZ2_A356SecUserPassword[0] ;
         A3CliCod = P02JZ2_A3CliCod[0] ;
         n3CliCod = P02JZ2_n3CliCod[0] ;
         AV19GXLvl3 = (byte)(1) ;
         AV10SecUserId = A67SecUserId ;
         AV15hash = AV16Argon2id.generateargon2idinteractive(AV9SecUserPassword, A2388SecUserSal) ;
         if ( GXutil.strcmp(A356SecUserPassword, AV15hash) == 0 )
         {
            AV11Existe = true ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV20Pgmname, "2") ;
            if ( ! (0==A3CliCod) )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV20Pgmname, "3") ;
               GXv_boolean1[0] = AV12CliManten ;
               new web.getclimanten(remoteHandle, context).execute( A3CliCod, GXv_boolean1) ;
               validarusupsw.this.AV12CliManten = GXv_boolean1[0] ;
               if ( AV12CliManten )
               {
                  httpContext.GX_msglist.addItem(httpContext.getMessage( "El sistema se encuentra en mantenimiento, intentar más tarde", ""));
               }
               else
               {
                  AV13LogInSuccessful = true ;
               }
               AV14CliCod = A3CliCod ;
            }
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV19GXLvl3 == 0 )
      {
         AV11Existe = false ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV20Pgmname, "4") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = validarusupsw.this.AV11Existe;
      this.aP3[0] = validarusupsw.this.AV13LogInSuccessful;
      this.aP4[0] = validarusupsw.this.AV14CliCod;
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
      P02JZ2_A364SecUsuActivo = new boolean[] {false} ;
      P02JZ2_A68SecUserName = new String[] {""} ;
      P02JZ2_A67SecUserId = new short[1] ;
      P02JZ2_A2388SecUserSal = new String[] {""} ;
      P02JZ2_A356SecUserPassword = new String[] {""} ;
      P02JZ2_A3CliCod = new int[1] ;
      P02JZ2_n3CliCod = new boolean[] {false} ;
      A68SecUserName = "" ;
      A2388SecUserSal = "" ;
      A356SecUserPassword = "" ;
      AV15hash = "" ;
      AV16Argon2id = new web.SdtArgon2id(remoteHandle, context);
      AV20Pgmname = "" ;
      GXv_boolean1 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.validarusupsw__default(),
         new Object[] {
             new Object[] {
            P02JZ2_A364SecUsuActivo, P02JZ2_A68SecUserName, P02JZ2_A67SecUserId, P02JZ2_A2388SecUserSal, P02JZ2_A356SecUserPassword, P02JZ2_A3CliCod, P02JZ2_n3CliCod
            }
         }
      );
      AV20Pgmname = "validarUsuPsw" ;
      /* GeneXus formulas. */
      AV20Pgmname = "validarUsuPsw" ;
      Gx_err = (short)(0) ;
   }

   private byte AV19GXLvl3 ;
   private short A67SecUserId ;
   private short AV10SecUserId ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String AV20Pgmname ;
   private boolean AV11Existe ;
   private boolean AV13LogInSuccessful ;
   private boolean A364SecUsuActivo ;
   private boolean n3CliCod ;
   private boolean AV12CliManten ;
   private boolean GXv_boolean1[] ;
   private String AV8SecUserName ;
   private String AV9SecUserPassword ;
   private String A68SecUserName ;
   private String A2388SecUserSal ;
   private String A356SecUserPassword ;
   private String AV15hash ;
   private web.SdtArgon2id AV16Argon2id ;
   private int[] aP4 ;
   private boolean[] aP2 ;
   private boolean[] aP3 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P02JZ2_A364SecUsuActivo ;
   private String[] P02JZ2_A68SecUserName ;
   private short[] P02JZ2_A67SecUserId ;
   private String[] P02JZ2_A2388SecUserSal ;
   private String[] P02JZ2_A356SecUserPassword ;
   private int[] P02JZ2_A3CliCod ;
   private boolean[] P02JZ2_n3CliCod ;
}

final  class validarusupsw__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02JZ2", "SELECT SecUsuActivo, SecUserName, SecUserId, SecUserSal, SecUserPassword, CliCod FROM SecUser WHERE (SecUserName = ( ?)) AND (SecUsuActivo = TRUE) ORDER BY SecUserName ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
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
               stmt.setVarchar(1, (String)parms[0], 100);
               return;
      }
   }

}

