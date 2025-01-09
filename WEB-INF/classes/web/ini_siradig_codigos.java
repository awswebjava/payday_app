package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ini_siradig_codigos extends GXProcedure
{
   public ini_siradig_codigos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ini_siradig_codigos.class ), "" );
   }

   public ini_siradig_codigos( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int aP0 )
   {
      ini_siradig_codigos.this.AV8CliCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE siradig_codigos

      */
      A3CliCod = AV8CliCod ;
      A1101SiraTipo = "RTO" ;
      A1102SiraCodigo = "" ;
      GXt_char1 = A1100SiraConCodigo ;
      GXv_char2[0] = GXt_char1 ;
      new web.getconceptopordesc(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "Beneficio guardería", ""), GXv_char2) ;
      ini_siradig_codigos.this.GXt_char1 = GXv_char2[0] ;
      A1100SiraConCodigo = GXt_char1 ;
      A1103SiraPropor = DecimalUtil.doubleToDec(1) ;
      /* Using cursor P016W2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo, A1100SiraConCodigo, A1103SiraPropor});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
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
         INSERT RECORD ON TABLE siradig_codigos

      */
      A3CliCod = AV8CliCod ;
      A1101SiraTipo = "DED" ;
      A1102SiraCodigo = "1" ;
      A1100SiraConCodigo = httpContext.getMessage( "DED001", "") ;
      A1103SiraPropor = DecimalUtil.doubleToDec(1) ;
      /* Using cursor P016W3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo, A1100SiraConCodigo, A1103SiraPropor});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
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
         INSERT RECORD ON TABLE siradig_codigos

      */
      A3CliCod = AV8CliCod ;
      A1101SiraTipo = "DED" ;
      A1102SiraCodigo = "2" ;
      A1100SiraConCodigo = httpContext.getMessage( "DED002", "") ;
      A1103SiraPropor = DecimalUtil.doubleToDec(1) ;
      /* Using cursor P016W4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo, A1100SiraConCodigo, A1103SiraPropor});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
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
      /*
         INSERT RECORD ON TABLE siradig_codigos

      */
      A3CliCod = AV8CliCod ;
      A1101SiraTipo = "DED" ;
      A1102SiraCodigo = "3" ;
      A1100SiraConCodigo = httpContext.getMessage( "DED003", "") ;
      A1103SiraPropor = DecimalUtil.doubleToDec(1) ;
      /* Using cursor P016W5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo, A1100SiraConCodigo, A1103SiraPropor});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
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
         INSERT RECORD ON TABLE siradig_codigos

      */
      A3CliCod = AV8CliCod ;
      A1101SiraTipo = "DED" ;
      A1102SiraCodigo = "4" ;
      A1100SiraConCodigo = httpContext.getMessage( "DED004", "") ;
      A1103SiraPropor = DecimalUtil.doubleToDec(1) ;
      /* Using cursor P016W6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo, A1100SiraConCodigo, A1103SiraPropor});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
      if ( (pr_default.getStatus(4) == 1) )
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
         INSERT RECORD ON TABLE siradig_codigos

      */
      A3CliCod = AV8CliCod ;
      A1101SiraTipo = "DED" ;
      A1102SiraCodigo = "5" ;
      A1100SiraConCodigo = httpContext.getMessage( "DED005", "") ;
      A1103SiraPropor = DecimalUtil.doubleToDec(1) ;
      /* Using cursor P016W7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo, A1100SiraConCodigo, A1103SiraPropor});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
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
      /*
         INSERT RECORD ON TABLE siradig_codigos

      */
      A3CliCod = AV8CliCod ;
      A1101SiraTipo = "DED" ;
      A1102SiraCodigo = "7" ;
      A1100SiraConCodigo = httpContext.getMessage( "DED007", "") ;
      A1103SiraPropor = DecimalUtil.stringToDec("0.4") ;
      /* Using cursor P016W8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo, A1100SiraConCodigo, A1103SiraPropor});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
      if ( (pr_default.getStatus(6) == 1) )
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
         INSERT RECORD ON TABLE siradig_codigos

      */
      A3CliCod = AV8CliCod ;
      A1101SiraTipo = "DED" ;
      A1102SiraCodigo = "8" ;
      A1100SiraConCodigo = httpContext.getMessage( "DED008", "") ;
      A1103SiraPropor = DecimalUtil.doubleToDec(1) ;
      /* Using cursor P016W9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo, A1100SiraConCodigo, A1103SiraPropor});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
      if ( (pr_default.getStatus(7) == 1) )
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
         INSERT RECORD ON TABLE siradig_codigos

      */
      A3CliCod = AV8CliCod ;
      A1101SiraTipo = "DED" ;
      A1102SiraCodigo = "9" ;
      A1100SiraConCodigo = httpContext.getMessage( "DED009", "") ;
      A1103SiraPropor = DecimalUtil.doubleToDec(1) ;
      /* Using cursor P016W10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo, A1100SiraConCodigo, A1103SiraPropor});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
      if ( (pr_default.getStatus(8) == 1) )
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
         INSERT RECORD ON TABLE siradig_codigos

      */
      A3CliCod = AV8CliCod ;
      A1101SiraTipo = "DED" ;
      A1102SiraCodigo = "10" ;
      A1100SiraConCodigo = httpContext.getMessage( "DED010", "") ;
      A1103SiraPropor = DecimalUtil.doubleToDec(1) ;
      /* Using cursor P016W11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo, A1100SiraConCodigo, A1103SiraPropor});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
      if ( (pr_default.getStatus(9) == 1) )
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
         INSERT RECORD ON TABLE siradig_codigos

      */
      A3CliCod = AV8CliCod ;
      A1101SiraTipo = "DED" ;
      A1102SiraCodigo = "11" ;
      A1100SiraConCodigo = httpContext.getMessage( "DED011", "") ;
      A1103SiraPropor = DecimalUtil.doubleToDec(1) ;
      /* Using cursor P016W12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo, A1100SiraConCodigo, A1103SiraPropor});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
      if ( (pr_default.getStatus(10) == 1) )
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
         INSERT RECORD ON TABLE siradig_codigos

      */
      A3CliCod = AV8CliCod ;
      A1101SiraTipo = "DED" ;
      A1102SiraCodigo = "21" ;
      A1100SiraConCodigo = httpContext.getMessage( "DED021", "") ;
      A1103SiraPropor = DecimalUtil.doubleToDec(1) ;
      /* Using cursor P016W13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo, A1100SiraConCodigo, A1103SiraPropor});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
      if ( (pr_default.getStatus(11) == 1) )
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
         INSERT RECORD ON TABLE siradig_codigos

      */
      A3CliCod = AV8CliCod ;
      A1101SiraTipo = "DED" ;
      A1102SiraCodigo = "22" ;
      A1100SiraConCodigo = httpContext.getMessage( "DED022", "") ;
      A1103SiraPropor = DecimalUtil.stringToDec("0.4") ;
      /* Using cursor P016W14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo, A1100SiraConCodigo, A1103SiraPropor});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
      if ( (pr_default.getStatus(12) == 1) )
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
         INSERT RECORD ON TABLE siradig_codigos

      */
      A3CliCod = AV8CliCod ;
      A1101SiraTipo = "DED" ;
      A1102SiraCodigo = "33" ;
      A1100SiraConCodigo = httpContext.getMessage( "DED033", "") ;
      A1103SiraPropor = DecimalUtil.stringToDec("0.1") ;
      /* Using cursor P016W15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo, A1100SiraConCodigo, A1103SiraPropor});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
      if ( (pr_default.getStatus(13) == 1) )
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
      new web.msgdebug_prod(remoteHandle, context).execute( AV11Pgmname, httpContext.getMessage( "compiló...", "")) ;
      /*
         INSERT RECORD ON TABLE siradig_codigos

      */
      A3CliCod = AV8CliCod ;
      A1101SiraTipo = "DED" ;
      A1102SiraCodigo = "34" ;
      A1100SiraConCodigo = httpContext.getMessage( "DED034", "") ;
      A1103SiraPropor = DecimalUtil.stringToDec("0.1") ;
      /* Using cursor P016W16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo, A1100SiraConCodigo, A1103SiraPropor});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
      if ( (pr_default.getStatus(14) == 1) )
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
         INSERT RECORD ON TABLE siradig_codigos

      */
      A3CliCod = AV8CliCod ;
      A1101SiraTipo = "DED" ;
      A1102SiraCodigo = "23" ;
      A1100SiraConCodigo = httpContext.getMessage( "DED023", "") ;
      A1103SiraPropor = DecimalUtil.doubleToDec(1) ;
      /* Using cursor P016W17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo, A1100SiraConCodigo, A1103SiraPropor});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
      if ( (pr_default.getStatus(15) == 1) )
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
         INSERT RECORD ON TABLE siradig_codigos

      */
      A3CliCod = AV8CliCod ;
      A1101SiraTipo = "DED" ;
      A1102SiraCodigo = "24" ;
      A1100SiraConCodigo = httpContext.getMessage( "DED024", "") ;
      A1103SiraPropor = DecimalUtil.doubleToDec(1) ;
      /* Using cursor P016W18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo, A1100SiraConCodigo, A1103SiraPropor});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
      if ( (pr_default.getStatus(16) == 1) )
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
         INSERT RECORD ON TABLE siradig_codigos

      */
      A3CliCod = AV8CliCod ;
      A1101SiraTipo = "DED" ;
      A1102SiraCodigo = "25" ;
      A1100SiraConCodigo = httpContext.getMessage( "DED025", "") ;
      A1103SiraPropor = DecimalUtil.doubleToDec(1) ;
      /* Using cursor P016W19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo, A1100SiraConCodigo, A1103SiraPropor});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
      if ( (pr_default.getStatus(17) == 1) )
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
         INSERT RECORD ON TABLE siradig_codigos

      */
      A3CliCod = AV8CliCod ;
      A1101SiraTipo = "DED" ;
      A1102SiraCodigo = "32" ;
      A1100SiraConCodigo = httpContext.getMessage( "DED032", "") ;
      A1103SiraPropor = DecimalUtil.doubleToDec(1) ;
      /* Using cursor P016W20 */
      pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), A1101SiraTipo, A1102SiraCodigo, A1100SiraConCodigo, A1103SiraPropor});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("siradig_codigos");
      if ( (pr_default.getStatus(18) == 1) )
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
      Application.commitDataStores(context, remoteHandle, pr_default, "ini_siradig_codigos");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A1101SiraTipo = "" ;
      A1102SiraCodigo = "" ;
      A1100SiraConCodigo = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      A1103SiraPropor = DecimalUtil.ZERO ;
      Gx_emsg = "" ;
      AV11Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ini_siradig_codigos__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV11Pgmname = "ini_siradig_codigos" ;
      /* GeneXus formulas. */
      AV11Pgmname = "ini_siradig_codigos" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int GX_INS123 ;
   private int A3CliCod ;
   private java.math.BigDecimal A1103SiraPropor ;
   private String A1101SiraTipo ;
   private String A1102SiraCodigo ;
   private String A1100SiraConCodigo ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String Gx_emsg ;
   private String AV11Pgmname ;
   private IDataStoreProvider pr_default ;
}

final  class ini_siradig_codigos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P016W2", "SAVEPOINT gxupdate;INSERT INTO siradig_codigos(CliCod, SiraTipo, SiraCodigo, SiraConCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld) VALUES(?, ?, ?, ?, ?, 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P016W3", "SAVEPOINT gxupdate;INSERT INTO siradig_codigos(CliCod, SiraTipo, SiraCodigo, SiraConCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld) VALUES(?, ?, ?, ?, ?, 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P016W4", "SAVEPOINT gxupdate;INSERT INTO siradig_codigos(CliCod, SiraTipo, SiraCodigo, SiraConCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld) VALUES(?, ?, ?, ?, ?, 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P016W5", "SAVEPOINT gxupdate;INSERT INTO siradig_codigos(CliCod, SiraTipo, SiraCodigo, SiraConCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld) VALUES(?, ?, ?, ?, ?, 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P016W6", "SAVEPOINT gxupdate;INSERT INTO siradig_codigos(CliCod, SiraTipo, SiraCodigo, SiraConCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld) VALUES(?, ?, ?, ?, ?, 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P016W7", "SAVEPOINT gxupdate;INSERT INTO siradig_codigos(CliCod, SiraTipo, SiraCodigo, SiraConCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld) VALUES(?, ?, ?, ?, ?, 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P016W8", "SAVEPOINT gxupdate;INSERT INTO siradig_codigos(CliCod, SiraTipo, SiraCodigo, SiraConCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld) VALUES(?, ?, ?, ?, ?, 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P016W9", "SAVEPOINT gxupdate;INSERT INTO siradig_codigos(CliCod, SiraTipo, SiraCodigo, SiraConCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld) VALUES(?, ?, ?, ?, ?, 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P016W10", "SAVEPOINT gxupdate;INSERT INTO siradig_codigos(CliCod, SiraTipo, SiraCodigo, SiraConCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld) VALUES(?, ?, ?, ?, ?, 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P016W11", "SAVEPOINT gxupdate;INSERT INTO siradig_codigos(CliCod, SiraTipo, SiraCodigo, SiraConCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld) VALUES(?, ?, ?, ?, ?, 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P016W12", "SAVEPOINT gxupdate;INSERT INTO siradig_codigos(CliCod, SiraTipo, SiraCodigo, SiraConCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld) VALUES(?, ?, ?, ?, ?, 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P016W13", "SAVEPOINT gxupdate;INSERT INTO siradig_codigos(CliCod, SiraTipo, SiraCodigo, SiraConCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld) VALUES(?, ?, ?, ?, ?, 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P016W14", "SAVEPOINT gxupdate;INSERT INTO siradig_codigos(CliCod, SiraTipo, SiraCodigo, SiraConCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld) VALUES(?, ?, ?, ?, ?, 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P016W15", "SAVEPOINT gxupdate;INSERT INTO siradig_codigos(CliCod, SiraTipo, SiraCodigo, SiraConCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld) VALUES(?, ?, ?, ?, ?, 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P016W16", "SAVEPOINT gxupdate;INSERT INTO siradig_codigos(CliCod, SiraTipo, SiraCodigo, SiraConCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld) VALUES(?, ?, ?, ?, ?, 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P016W17", "SAVEPOINT gxupdate;INSERT INTO siradig_codigos(CliCod, SiraTipo, SiraCodigo, SiraConCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld) VALUES(?, ?, ?, ?, ?, 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P016W18", "SAVEPOINT gxupdate;INSERT INTO siradig_codigos(CliCod, SiraTipo, SiraCodigo, SiraConCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld) VALUES(?, ?, ?, ?, ?, 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P016W19", "SAVEPOINT gxupdate;INSERT INTO siradig_codigos(CliCod, SiraTipo, SiraCodigo, SiraConCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld) VALUES(?, ?, ?, ?, ?, 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P016W20", "SAVEPOINT gxupdate;INSERT INTO siradig_codigos(CliCod, SiraTipo, SiraCodigo, SiraConCodigo, SiraPropor, SiraRelSec, SiraRelSecCli, SiraTipoPadre, SiraCodPadre, SiraRelRef, SiraOld) VALUES(?, ?, ?, ?, ?, 0, 0, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 10);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 10);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 10);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 10);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 10);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 10);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 10);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 10);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 10);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 10);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 10);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 10);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 10);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 10);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 10);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 10);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 10);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 10);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 3);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 10);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               return;
      }
   }

}

