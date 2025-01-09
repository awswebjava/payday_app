package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class reportarconceptosnousados extends GXProcedure
{
   public reportarconceptosnousados( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( reportarconceptosnousados.class ), "" );
   }

   public reportarconceptosnousados( int remoteHandle ,
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
      reportarconceptosnousados.this.AV8clicod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00IF2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8clicod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00IF2_A3CliCod[0] ;
         A26ConCodigo = P00IF2_A26ConCodigo[0] ;
         A37TipoConCod = P00IF2_A37TipoConCod[0] ;
         A41ConDescrip = P00IF2_A41ConDescrip[0] ;
         A469ConCodOld = P00IF2_A469ConCodOld[0] ;
         if ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "CAL023", "")) == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "HOLA", "")) ;
         }
         if ( ! new web.esconceptoimprimible(remoteHandle, context).executeUdp( A37TipoConCod) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            if ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "CAL023", "")) == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "MUNDO", "")) ;
            }
            GXv_boolean1[0] = AV10seusa ;
            GXv_boolean2[0] = false ;
            GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem3[0] = AV9sdt_conceptos ;
            GXv_boolean4[0] = false ;
            new web.analizarconceptosuso(remoteHandle, context).execute( A3CliCod, (short)(0), 0, 0, A26ConCodigo, AV11TipoConCod, httpContext.getMessage( "TODOS", ""), true, true, false, GXv_boolean1, GXv_boolean2, GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem3, GXv_boolean4) ;
            reportarconceptosnousados.this.AV10seusa = GXv_boolean1[0] ;
            AV9sdt_conceptos = GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem3[0] ;
            if ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "CAL023", "")) == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, GXutil.trim( A26ConCodigo)+httpContext.getMessage( " &seusa ", "")+GXutil.trim( GXutil.booltostr( AV10seusa))+httpContext.getMessage( " &sdt_conceptos", "")+AV9sdt_conceptos.toJSonString(false)) ;
            }
            if ( ! AV10seusa )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, GXutil.trim( A26ConCodigo)+httpContext.getMessage( " NO SE USA: ", "")+GXutil.trim( A26ConCodigo)+" - "+GXutil.trim( A469ConCodOld)+" - "+GXutil.trim( A41ConDescrip)) ;
            }
            else
            {
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
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
      scmdbuf = "" ;
      P00IF2_A3CliCod = new int[1] ;
      P00IF2_A26ConCodigo = new String[] {""} ;
      P00IF2_A37TipoConCod = new String[] {""} ;
      P00IF2_A41ConDescrip = new String[] {""} ;
      P00IF2_A469ConCodOld = new String[] {""} ;
      A26ConCodigo = "" ;
      A37TipoConCod = "" ;
      A41ConDescrip = "" ;
      A469ConCodOld = "" ;
      AV15Pgmname = "" ;
      AV11TipoConCod = "" ;
      GXv_boolean1 = new boolean[1] ;
      GXv_boolean2 = new boolean[1] ;
      AV9sdt_conceptos = new GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem>(web.Sdtsdt_conceptos_sdt_conceptosItem.class, "sdt_conceptosItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem3 = new GXBaseCollection[1] ;
      GXv_boolean4 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.reportarconceptosnousados__default(),
         new Object[] {
             new Object[] {
            P00IF2_A3CliCod, P00IF2_A26ConCodigo, P00IF2_A37TipoConCod, P00IF2_A41ConDescrip, P00IF2_A469ConCodOld
            }
         }
      );
      AV15Pgmname = "reportarConceptosNoUsados" ;
      /* GeneXus formulas. */
      AV15Pgmname = "reportarConceptosNoUsados" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8clicod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A37TipoConCod ;
   private String A469ConCodOld ;
   private String AV15Pgmname ;
   private String AV11TipoConCod ;
   private boolean Cond_result ;
   private boolean AV10seusa ;
   private boolean GXv_boolean1[] ;
   private boolean GXv_boolean2[] ;
   private boolean GXv_boolean4[] ;
   private String A41ConDescrip ;
   private IDataStoreProvider pr_default ;
   private int[] P00IF2_A3CliCod ;
   private String[] P00IF2_A26ConCodigo ;
   private String[] P00IF2_A37TipoConCod ;
   private String[] P00IF2_A41ConDescrip ;
   private String[] P00IF2_A469ConCodOld ;
   private GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem> AV9sdt_conceptos ;
   private GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem> GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem3[] ;
}

final  class reportarconceptosnousados__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00IF2", "SELECT CliCod, ConCodigo, TipoConCod, ConDescrip, ConCodOld FROM Concepto WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
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
      }
   }

}

