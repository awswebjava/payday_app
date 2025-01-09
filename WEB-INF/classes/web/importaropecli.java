package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importaropecli extends GXProcedure
{
   public importaropecli( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importaropecli.class ), "" );
   }

   public importaropecli( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        int aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             int aP1 )
   {
      importaropecli.this.AV8origenCliCod = aP0;
      importaropecli.this.AV9CliCod = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00RJ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8origenCliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2140VarDetail = P00RJ2_A2140VarDetail[0] ;
         A2025VarOld = P00RJ2_A2025VarOld[0] ;
         A2011VarRelRef = P00RJ2_A2011VarRelRef[0] ;
         A1906OpeCliIdPadre = P00RJ2_A1906OpeCliIdPadre[0] ;
         A1903ValRelSecCli = P00RJ2_A1903ValRelSecCli[0] ;
         A934OpeCliAliEs = P00RJ2_A934OpeCliAliEs[0] ;
         A931OpeCliEsCant = P00RJ2_A931OpeCliEsCant[0] ;
         A741OpeCLiAliLey = P00RJ2_A741OpeCLiAliLey[0] ;
         A545OpeCliFecCre = P00RJ2_A545OpeCliFecCre[0] ;
         A544OpeCliUsuCre = P00RJ2_A544OpeCliUsuCre[0] ;
         A536OpeCliIdMay = P00RJ2_A536OpeCliIdMay[0] ;
         A534OpeCliDescrip = P00RJ2_A534OpeCliDescrip[0] ;
         A549OpeCliCodFormula = P00RJ2_A549OpeCliCodFormula[0] ;
         A82OpeCliId = P00RJ2_A82OpeCliId[0] ;
         A3CliCod = P00RJ2_A3CliCod[0] ;
         A2139VarHelp = P00RJ2_A2139VarHelp[0] ;
         A2129VarActObl = P00RJ2_A2129VarActObl[0] ;
         A1921VarScrapFin = P00RJ2_A1921VarScrapFin[0] ;
         n1921VarScrapFin = P00RJ2_n1921VarScrapFin[0] ;
         A1913VarFrecAct = P00RJ2_A1913VarFrecAct[0] ;
         A1912VarScrapTipo = P00RJ2_A1912VarScrapTipo[0] ;
         n1912VarScrapTipo = P00RJ2_n1912VarScrapTipo[0] ;
         A1911VarScrapTDoc = P00RJ2_A1911VarScrapTDoc[0] ;
         n1911VarScrapTDoc = P00RJ2_n1911VarScrapTDoc[0] ;
         A1910VarBaseURL = P00RJ2_A1910VarBaseURL[0] ;
         n1910VarBaseURL = P00RJ2_n1910VarBaseURL[0] ;
         A1909VarBusWeb = P00RJ2_A1909VarBusWeb[0] ;
         n1909VarBusWeb = P00RJ2_n1909VarBusWeb[0] ;
         A1908VarBusGoogle = P00RJ2_A1908VarBusGoogle[0] ;
         n1908VarBusGoogle = P00RJ2_n1908VarBusGoogle[0] ;
         A1895VarRelSec = P00RJ2_A1895VarRelSec[0] ;
         W3CliCod = A3CliCod ;
         AV10OpeCliId = A82OpeCliId ;
         AV17OpeCliCodFormula = A549OpeCliCodFormula ;
         AV16OpeCliDescrip = A534OpeCliDescrip ;
         AV11OpeCliValor = A535OpeCliValor ;
         AV15OpeCliIdMay = A536OpeCliIdMay ;
         AV13OpeCLiAliLey = A741OpeCLiAliLey ;
         AV19OpeCliEsCant = A931OpeCliEsCant ;
         AV20OpeCliAliEs = A934OpeCliAliEs ;
         /*
            INSERT RECORD ON TABLE Variable

         */
         W3CliCod = A3CliCod ;
         W82OpeCliId = A82OpeCliId ;
         W549OpeCliCodFormula = A549OpeCliCodFormula ;
         W534OpeCliDescrip = A534OpeCliDescrip ;
         W536OpeCliIdMay = A536OpeCliIdMay ;
         W544OpeCliUsuCre = A544OpeCliUsuCre ;
         W545OpeCliFecCre = A545OpeCliFecCre ;
         W741OpeCLiAliLey = A741OpeCLiAliLey ;
         W931OpeCliEsCant = A931OpeCliEsCant ;
         W934OpeCliAliEs = A934OpeCliAliEs ;
         W1903ValRelSecCli = A1903ValRelSecCli ;
         W1906OpeCliIdPadre = A1906OpeCliIdPadre ;
         W2011VarRelRef = A2011VarRelRef ;
         W2025VarOld = A2025VarOld ;
         W2140VarDetail = A2140VarDetail ;
         A3CliCod = AV9CliCod ;
         A82OpeCliId = AV10OpeCliId ;
         A549OpeCliCodFormula = AV17OpeCliCodFormula ;
         A534OpeCliDescrip = AV16OpeCliDescrip ;
         A536OpeCliIdMay = AV15OpeCliIdMay ;
         GXt_char1 = A544OpeCliUsuCre ;
         GXv_char2[0] = GXt_char1 ;
         new web.getusulogged(remoteHandle, context).execute( GXv_char2) ;
         importaropecli.this.GXt_char1 = GXv_char2[0] ;
         A544OpeCliUsuCre = GXt_char1 ;
         A545OpeCliFecCre = GXutil.serverDate( context, remoteHandle, pr_default) ;
         A741OpeCLiAliLey = AV13OpeCLiAliLey ;
         A931OpeCliEsCant = AV19OpeCliEsCant ;
         A934OpeCliAliEs = AV20OpeCliAliEs ;
         A1903ValRelSecCli = AV8origenCliCod ;
         A1906OpeCliIdPadre = AV10OpeCliId ;
         A2011VarRelRef = "" ;
         A2025VarOld = "" ;
         A2140VarDetail = "" ;
         /* Using cursor P00RJ3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, A549OpeCliCodFormula, A534OpeCliDescrip, A536OpeCliIdMay, A544OpeCliUsuCre, A545OpeCliFecCre, Boolean.valueOf(A741OpeCLiAliLey), Boolean.valueOf(A931OpeCliEsCant), Boolean.valueOf(A934OpeCliAliEs), Integer.valueOf(A1895VarRelSec), Boolean.valueOf(n1908VarBusGoogle), A1908VarBusGoogle, Boolean.valueOf(n1909VarBusWeb), A1909VarBusWeb, Boolean.valueOf(n1910VarBaseURL), A1910VarBaseURL, Boolean.valueOf(n1911VarScrapTDoc), A1911VarScrapTDoc, Boolean.valueOf(n1912VarScrapTipo), A1912VarScrapTipo, Byte.valueOf(A1913VarFrecAct), Integer.valueOf(A1903ValRelSecCli), A1906OpeCliIdPadre, Boolean.valueOf(n1921VarScrapFin), A1921VarScrapFin, A2011VarRelRef, A2025VarOld, Boolean.valueOf(A2129VarActObl), A2139VarHelp, A2140VarDetail});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Variable");
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
         A3CliCod = W3CliCod ;
         A82OpeCliId = W82OpeCliId ;
         A549OpeCliCodFormula = W549OpeCliCodFormula ;
         A534OpeCliDescrip = W534OpeCliDescrip ;
         A536OpeCliIdMay = W536OpeCliIdMay ;
         A544OpeCliUsuCre = W544OpeCliUsuCre ;
         A545OpeCliFecCre = W545OpeCliFecCre ;
         A741OpeCLiAliLey = W741OpeCLiAliLey ;
         A931OpeCliEsCant = W931OpeCliEsCant ;
         A934OpeCliAliEs = W934OpeCliAliEs ;
         A1903ValRelSecCli = W1903ValRelSecCli ;
         A1906OpeCliIdPadre = W1906OpeCliIdPadre ;
         A2011VarRelRef = W2011VarRelRef ;
         A2025VarOld = W2025VarOld ;
         A2140VarDetail = W2140VarDetail ;
         /* End Insert */
         /* Using cursor P00RJ4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A2032OpeCliVOld = P00RJ4_A2032OpeCliVOld[0] ;
            A2010OpeCliVRelRef = P00RJ4_A2010OpeCliVRelRef[0] ;
            A535OpeCliValor = P00RJ4_A535OpeCliValor[0] ;
            A754OpeCliVig = P00RJ4_A754OpeCliVig[0] ;
            A1904OpeCliRelSecCli = P00RJ4_A1904OpeCliRelSecCli[0] ;
            A1890OpeCliRelSec = P00RJ4_A1890OpeCliRelSec[0] ;
            A1146OpeCliVRetro = P00RJ4_A1146OpeCliVRetro[0] ;
            n1146OpeCliVRetro = P00RJ4_n1146OpeCliVRetro[0] ;
            A924OpeCliVPropagar = P00RJ4_A924OpeCliVPropagar[0] ;
            n924OpeCliVPropagar = P00RJ4_n924OpeCliVPropagar[0] ;
            W3CliCod = A3CliCod ;
            W82OpeCliId = A82OpeCliId ;
            AV18OpeCliVig = A754OpeCliVig ;
            AV11OpeCliValor = A535OpeCliValor ;
            /*
               INSERT RECORD ON TABLE variable_valores

            */
            W3CliCod = A3CliCod ;
            W82OpeCliId = A82OpeCliId ;
            W754OpeCliVig = A754OpeCliVig ;
            W535OpeCliValor = A535OpeCliValor ;
            W2010OpeCliVRelRef = A2010OpeCliVRelRef ;
            W2032OpeCliVOld = A2032OpeCliVOld ;
            A3CliCod = AV9CliCod ;
            A82OpeCliId = AV10OpeCliId ;
            A754OpeCliVig = AV18OpeCliVig ;
            A535OpeCliValor = AV11OpeCliValor ;
            A2010OpeCliVRelRef = "" ;
            A2032OpeCliVOld = "" ;
            /* Using cursor P00RJ5 */
            pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig, A535OpeCliValor, Boolean.valueOf(n924OpeCliVPropagar), Boolean.valueOf(A924OpeCliVPropagar), Boolean.valueOf(n1146OpeCliVRetro), A1146OpeCliVRetro, Integer.valueOf(A1890OpeCliRelSec), Integer.valueOf(A1904OpeCliRelSecCli), A2010OpeCliVRelRef, A2032OpeCliVOld});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("variable_valores");
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
            A3CliCod = W3CliCod ;
            A82OpeCliId = W82OpeCliId ;
            A754OpeCliVig = W754OpeCliVig ;
            A535OpeCliValor = W535OpeCliValor ;
            A2010OpeCliVRelRef = W2010OpeCliVRelRef ;
            A2032OpeCliVOld = W2032OpeCliVOld ;
            /* End Insert */
            A3CliCod = W3CliCod ;
            A82OpeCliId = W82OpeCliId ;
            pr_default.readNext(2);
         }
         pr_default.close(2);
         A3CliCod = W3CliCod ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "importaropecli");
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
      P00RJ2_A2140VarDetail = new String[] {""} ;
      P00RJ2_A2025VarOld = new String[] {""} ;
      P00RJ2_A2011VarRelRef = new String[] {""} ;
      P00RJ2_A1906OpeCliIdPadre = new String[] {""} ;
      P00RJ2_A1903ValRelSecCli = new int[1] ;
      P00RJ2_A934OpeCliAliEs = new boolean[] {false} ;
      P00RJ2_A931OpeCliEsCant = new boolean[] {false} ;
      P00RJ2_A741OpeCLiAliLey = new boolean[] {false} ;
      P00RJ2_A545OpeCliFecCre = new java.util.Date[] {GXutil.nullDate()} ;
      P00RJ2_A544OpeCliUsuCre = new String[] {""} ;
      P00RJ2_A536OpeCliIdMay = new String[] {""} ;
      P00RJ2_A534OpeCliDescrip = new String[] {""} ;
      P00RJ2_A549OpeCliCodFormula = new String[] {""} ;
      P00RJ2_A82OpeCliId = new String[] {""} ;
      P00RJ2_A3CliCod = new int[1] ;
      P00RJ2_A2139VarHelp = new String[] {""} ;
      P00RJ2_A2129VarActObl = new boolean[] {false} ;
      P00RJ2_A1921VarScrapFin = new String[] {""} ;
      P00RJ2_n1921VarScrapFin = new boolean[] {false} ;
      P00RJ2_A1913VarFrecAct = new byte[1] ;
      P00RJ2_A1912VarScrapTipo = new String[] {""} ;
      P00RJ2_n1912VarScrapTipo = new boolean[] {false} ;
      P00RJ2_A1911VarScrapTDoc = new String[] {""} ;
      P00RJ2_n1911VarScrapTDoc = new boolean[] {false} ;
      P00RJ2_A1910VarBaseURL = new String[] {""} ;
      P00RJ2_n1910VarBaseURL = new boolean[] {false} ;
      P00RJ2_A1909VarBusWeb = new String[] {""} ;
      P00RJ2_n1909VarBusWeb = new boolean[] {false} ;
      P00RJ2_A1908VarBusGoogle = new String[] {""} ;
      P00RJ2_n1908VarBusGoogle = new boolean[] {false} ;
      P00RJ2_A1895VarRelSec = new int[1] ;
      A2140VarDetail = "" ;
      A2025VarOld = "" ;
      A2011VarRelRef = "" ;
      A1906OpeCliIdPadre = "" ;
      A545OpeCliFecCre = GXutil.nullDate() ;
      A544OpeCliUsuCre = "" ;
      A536OpeCliIdMay = "" ;
      A534OpeCliDescrip = "" ;
      A549OpeCliCodFormula = "" ;
      A82OpeCliId = "" ;
      A2139VarHelp = "" ;
      A1921VarScrapFin = "" ;
      A1912VarScrapTipo = "" ;
      A1911VarScrapTDoc = "" ;
      A1910VarBaseURL = "" ;
      A1909VarBusWeb = "" ;
      A1908VarBusGoogle = "" ;
      AV10OpeCliId = "" ;
      AV17OpeCliCodFormula = "" ;
      AV16OpeCliDescrip = "" ;
      AV11OpeCliValor = "" ;
      A535OpeCliValor = "" ;
      AV15OpeCliIdMay = "" ;
      W82OpeCliId = "" ;
      W549OpeCliCodFormula = "" ;
      W534OpeCliDescrip = "" ;
      W536OpeCliIdMay = "" ;
      W544OpeCliUsuCre = "" ;
      W545OpeCliFecCre = GXutil.nullDate() ;
      W1906OpeCliIdPadre = "" ;
      W2011VarRelRef = "" ;
      W2025VarOld = "" ;
      W2140VarDetail = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      Gx_emsg = "" ;
      P00RJ4_A3CliCod = new int[1] ;
      P00RJ4_A82OpeCliId = new String[] {""} ;
      P00RJ4_A2032OpeCliVOld = new String[] {""} ;
      P00RJ4_A2010OpeCliVRelRef = new String[] {""} ;
      P00RJ4_A535OpeCliValor = new String[] {""} ;
      P00RJ4_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      P00RJ4_A1904OpeCliRelSecCli = new int[1] ;
      P00RJ4_A1890OpeCliRelSec = new int[1] ;
      P00RJ4_A1146OpeCliVRetro = new java.util.Date[] {GXutil.nullDate()} ;
      P00RJ4_n1146OpeCliVRetro = new boolean[] {false} ;
      P00RJ4_A924OpeCliVPropagar = new boolean[] {false} ;
      P00RJ4_n924OpeCliVPropagar = new boolean[] {false} ;
      A2032OpeCliVOld = "" ;
      A2010OpeCliVRelRef = "" ;
      A754OpeCliVig = GXutil.nullDate() ;
      A1146OpeCliVRetro = GXutil.nullDate() ;
      AV18OpeCliVig = GXutil.nullDate() ;
      W754OpeCliVig = GXutil.nullDate() ;
      W535OpeCliValor = "" ;
      W2010OpeCliVRelRef = "" ;
      W2032OpeCliVOld = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importaropecli__default(),
         new Object[] {
             new Object[] {
            P00RJ2_A2140VarDetail, P00RJ2_A2025VarOld, P00RJ2_A2011VarRelRef, P00RJ2_A1906OpeCliIdPadre, P00RJ2_A1903ValRelSecCli, P00RJ2_A934OpeCliAliEs, P00RJ2_A931OpeCliEsCant, P00RJ2_A741OpeCLiAliLey, P00RJ2_A545OpeCliFecCre, P00RJ2_A544OpeCliUsuCre,
            P00RJ2_A536OpeCliIdMay, P00RJ2_A534OpeCliDescrip, P00RJ2_A549OpeCliCodFormula, P00RJ2_A82OpeCliId, P00RJ2_A3CliCod, P00RJ2_A2139VarHelp, P00RJ2_A2129VarActObl, P00RJ2_A1921VarScrapFin, P00RJ2_n1921VarScrapFin, P00RJ2_A1913VarFrecAct,
            P00RJ2_A1912VarScrapTipo, P00RJ2_n1912VarScrapTipo, P00RJ2_A1911VarScrapTDoc, P00RJ2_n1911VarScrapTDoc, P00RJ2_A1910VarBaseURL, P00RJ2_n1910VarBaseURL, P00RJ2_A1909VarBusWeb, P00RJ2_n1909VarBusWeb, P00RJ2_A1908VarBusGoogle, P00RJ2_n1908VarBusGoogle,
            P00RJ2_A1895VarRelSec
            }
            , new Object[] {
            }
            , new Object[] {
            P00RJ4_A3CliCod, P00RJ4_A82OpeCliId, P00RJ4_A2032OpeCliVOld, P00RJ4_A2010OpeCliVRelRef, P00RJ4_A535OpeCliValor, P00RJ4_A754OpeCliVig, P00RJ4_A1904OpeCliRelSecCli, P00RJ4_A1890OpeCliRelSec, P00RJ4_A1146OpeCliVRetro, P00RJ4_n1146OpeCliVRetro,
            P00RJ4_A924OpeCliVPropagar, P00RJ4_n924OpeCliVPropagar
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1913VarFrecAct ;
   private short Gx_err ;
   private int AV8origenCliCod ;
   private int AV9CliCod ;
   private int A1903ValRelSecCli ;
   private int A3CliCod ;
   private int A1895VarRelSec ;
   private int W3CliCod ;
   private int GX_INS71 ;
   private int W1903ValRelSecCli ;
   private int A1904OpeCliRelSecCli ;
   private int A1890OpeCliRelSec ;
   private int GX_INS81 ;
   private String scmdbuf ;
   private String A1906OpeCliIdPadre ;
   private String A536OpeCliIdMay ;
   private String A549OpeCliCodFormula ;
   private String A82OpeCliId ;
   private String A1912VarScrapTipo ;
   private String A1911VarScrapTDoc ;
   private String AV10OpeCliId ;
   private String AV17OpeCliCodFormula ;
   private String AV15OpeCliIdMay ;
   private String W82OpeCliId ;
   private String W549OpeCliCodFormula ;
   private String W536OpeCliIdMay ;
   private String W1906OpeCliIdPadre ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String Gx_emsg ;
   private java.util.Date A545OpeCliFecCre ;
   private java.util.Date W545OpeCliFecCre ;
   private java.util.Date A754OpeCliVig ;
   private java.util.Date A1146OpeCliVRetro ;
   private java.util.Date AV18OpeCliVig ;
   private java.util.Date W754OpeCliVig ;
   private boolean A934OpeCliAliEs ;
   private boolean A931OpeCliEsCant ;
   private boolean A741OpeCLiAliLey ;
   private boolean A2129VarActObl ;
   private boolean n1921VarScrapFin ;
   private boolean n1912VarScrapTipo ;
   private boolean n1911VarScrapTDoc ;
   private boolean n1910VarBaseURL ;
   private boolean n1909VarBusWeb ;
   private boolean n1908VarBusGoogle ;
   private boolean AV13OpeCLiAliLey ;
   private boolean AV19OpeCliEsCant ;
   private boolean AV20OpeCliAliEs ;
   private boolean W741OpeCLiAliLey ;
   private boolean W931OpeCliEsCant ;
   private boolean W934OpeCliAliEs ;
   private boolean n1146OpeCliVRetro ;
   private boolean A924OpeCliVPropagar ;
   private boolean n924OpeCliVPropagar ;
   private String A2025VarOld ;
   private String A2139VarHelp ;
   private String AV11OpeCliValor ;
   private String A535OpeCliValor ;
   private String W2025VarOld ;
   private String A2032OpeCliVOld ;
   private String W535OpeCliValor ;
   private String W2032OpeCliVOld ;
   private String A2140VarDetail ;
   private String A2011VarRelRef ;
   private String A544OpeCliUsuCre ;
   private String A534OpeCliDescrip ;
   private String A1921VarScrapFin ;
   private String A1910VarBaseURL ;
   private String A1909VarBusWeb ;
   private String A1908VarBusGoogle ;
   private String AV16OpeCliDescrip ;
   private String W534OpeCliDescrip ;
   private String W544OpeCliUsuCre ;
   private String W2011VarRelRef ;
   private String W2140VarDetail ;
   private String A2010OpeCliVRelRef ;
   private String W2010OpeCliVRelRef ;
   private IDataStoreProvider pr_default ;
   private String[] P00RJ2_A2140VarDetail ;
   private String[] P00RJ2_A2025VarOld ;
   private String[] P00RJ2_A2011VarRelRef ;
   private String[] P00RJ2_A1906OpeCliIdPadre ;
   private int[] P00RJ2_A1903ValRelSecCli ;
   private boolean[] P00RJ2_A934OpeCliAliEs ;
   private boolean[] P00RJ2_A931OpeCliEsCant ;
   private boolean[] P00RJ2_A741OpeCLiAliLey ;
   private java.util.Date[] P00RJ2_A545OpeCliFecCre ;
   private String[] P00RJ2_A544OpeCliUsuCre ;
   private String[] P00RJ2_A536OpeCliIdMay ;
   private String[] P00RJ2_A534OpeCliDescrip ;
   private String[] P00RJ2_A549OpeCliCodFormula ;
   private String[] P00RJ2_A82OpeCliId ;
   private int[] P00RJ2_A3CliCod ;
   private String[] P00RJ2_A2139VarHelp ;
   private boolean[] P00RJ2_A2129VarActObl ;
   private String[] P00RJ2_A1921VarScrapFin ;
   private boolean[] P00RJ2_n1921VarScrapFin ;
   private byte[] P00RJ2_A1913VarFrecAct ;
   private String[] P00RJ2_A1912VarScrapTipo ;
   private boolean[] P00RJ2_n1912VarScrapTipo ;
   private String[] P00RJ2_A1911VarScrapTDoc ;
   private boolean[] P00RJ2_n1911VarScrapTDoc ;
   private String[] P00RJ2_A1910VarBaseURL ;
   private boolean[] P00RJ2_n1910VarBaseURL ;
   private String[] P00RJ2_A1909VarBusWeb ;
   private boolean[] P00RJ2_n1909VarBusWeb ;
   private String[] P00RJ2_A1908VarBusGoogle ;
   private boolean[] P00RJ2_n1908VarBusGoogle ;
   private int[] P00RJ2_A1895VarRelSec ;
   private int[] P00RJ4_A3CliCod ;
   private String[] P00RJ4_A82OpeCliId ;
   private String[] P00RJ4_A2032OpeCliVOld ;
   private String[] P00RJ4_A2010OpeCliVRelRef ;
   private String[] P00RJ4_A535OpeCliValor ;
   private java.util.Date[] P00RJ4_A754OpeCliVig ;
   private int[] P00RJ4_A1904OpeCliRelSecCli ;
   private int[] P00RJ4_A1890OpeCliRelSec ;
   private java.util.Date[] P00RJ4_A1146OpeCliVRetro ;
   private boolean[] P00RJ4_n1146OpeCliVRetro ;
   private boolean[] P00RJ4_A924OpeCliVPropagar ;
   private boolean[] P00RJ4_n924OpeCliVPropagar ;
}

final  class importaropecli__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00RJ2", "SELECT VarDetail, VarOld, VarRelRef, OpeCliIdPadre, ValRelSecCli, OpeCliAliEs, OpeCliEsCant, OpeCLiAliLey, OpeCliFecCre, OpeCliUsuCre, OpeCliIdMay, OpeCliDescrip, OpeCliCodFormula, OpeCliId, CliCod, VarHelp, VarActObl, VarScrapFin, VarFrecAct, VarScrapTipo, VarScrapTDoc, VarBaseURL, VarBusWeb, VarBusGoogle, VarRelSec FROM Variable WHERE (CliCod = ?) AND ((char_length(trim(trailing ' ' from OpeCliIdPadre))=0)) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00RJ3", "SAVEPOINT gxupdate;INSERT INTO Variable(CliCod, OpeCliId, OpeCliCodFormula, OpeCliDescrip, OpeCliIdMay, OpeCliUsuCre, OpeCliFecCre, OpeCLiAliLey, OpeCliEsCant, OpeCliAliEs, VarRelSec, VarBusGoogle, VarBusWeb, VarBaseURL, VarScrapTDoc, VarScrapTipo, VarFrecAct, ValRelSecCli, OpeCliIdPadre, VarScrapFin, VarRelRef, VarOld, VarActObl, VarHelp, VarDetail) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00RJ4", "SELECT CliCod, OpeCliId, OpeCliVOld, OpeCliVRelRef, OpeCliValor, OpeCliVig, OpeCliRelSecCli, OpeCliRelSec, OpeCliVRetro, OpeCliVPropagar FROM variable_valores WHERE CliCod = ? and OpeCliId = ( ?) ORDER BY CliCod, OpeCliId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00RJ5", "SAVEPOINT gxupdate;INSERT INTO variable_valores(CliCod, OpeCliId, OpeCliVig, OpeCliValor, OpeCliVPropagar, OpeCliVRetro, OpeCliRelSec, OpeCliRelSecCli, OpeCliVRelRef, OpeCliVOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 40);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 40);
               ((String[]) buf[13])[0] = rslt.getString(14, 40);
               ((int[]) buf[14])[0] = rslt.getInt(15);
               ((String[]) buf[15])[0] = rslt.getLongVarchar(16);
               ((boolean[]) buf[16])[0] = rslt.getBoolean(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((byte[]) buf[19])[0] = rslt.getByte(19);
               ((String[]) buf[20])[0] = rslt.getString(20, 20);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getString(21, 20);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getVarchar(22);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((String[]) buf[28])[0] = rslt.getVarchar(24);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((int[]) buf[30])[0] = rslt.getInt(25);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(9);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((boolean[]) buf[10])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setString(3, (String)parms[2], 40);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setString(5, (String)parms[4], 40);
               stmt.setVarchar(6, (String)parms[5], 100, false);
               stmt.setDate(7, (java.util.Date)parms[6]);
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               stmt.setBoolean(10, ((Boolean) parms[9]).booleanValue());
               stmt.setInt(11, ((Number) parms[10]).intValue());
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(12, (String)parms[12], 400);
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(13, (String)parms[14], 400);
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(14, (String)parms[16], 1000);
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(15, (String)parms[18], 20);
               }
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(16, (String)parms[20], 20);
               }
               stmt.setByte(17, ((Number) parms[21]).byteValue());
               stmt.setInt(18, ((Number) parms[22]).intValue());
               stmt.setString(19, (String)parms[23], 40);
               if ( ((Boolean) parms[24]).booleanValue() )
               {
                  stmt.setNull( 20 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(20, (String)parms[25], 400);
               }
               stmt.setVarchar(21, (String)parms[26], 40, false);
               stmt.setNLongVarchar(22, (String)parms[27], false);
               stmt.setBoolean(23, ((Boolean) parms[28]).booleanValue());
               stmt.setNLongVarchar(24, (String)parms[29], false);
               stmt.setVarchar(25, (String)parms[30], 400, false);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setNLongVarchar(4, (String)parms[3], false);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(5, ((Boolean) parms[5]).booleanValue());
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.DATE );
               }
               else
               {
                  stmt.setDate(6, (java.util.Date)parms[7]);
               }
               stmt.setInt(7, ((Number) parms[8]).intValue());
               stmt.setInt(8, ((Number) parms[9]).intValue());
               stmt.setVarchar(9, (String)parms[10], 40, false);
               stmt.setNLongVarchar(10, (String)parms[11], false);
               return;
      }
   }

}

