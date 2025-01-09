package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettxtbasecod2 extends GXProcedure
{
   public gettxtbasecod2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettxtbasecod2.class ), "" );
   }

   public gettxtbasecod2( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 )
   {
      gettxtbasecod2.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String[] aP4 )
   {
      gettxtbasecod2.this.AV11CliCod = aP0;
      gettxtbasecod2.this.AV8EmpBaseTipo = aP1;
      gettxtbasecod2.this.AV9EmpBaseCod1 = aP2;
      gettxtbasecod2.this.AV12EmpBaseCod2 = aP3;
      gettxtbasecod2.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV8EmpBaseTipo, "licencia") == 0 )
      {
         if ( (GXutil.strcmp("", AV12EmpBaseCod2)==0) )
         {
            AV10txt = "" ;
         }
         else
         {
            if ( ( GXutil.strcmp(AV9EmpBaseCod1, new web.codigodesituacioniltart(remoteHandle, context).executeUdp( AV11CliCod)) == 0 ) || ( GXutil.strcmp(AV9EmpBaseCod1, new web.codigodesituacioniltempresa(remoteHandle, context).executeUdp( AV11CliCod)) == 0 ) )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               GXv_char1[0] = AV10txt ;
               GXv_boolean2[0] = false ;
               new web.getsiniestrado(remoteHandle, context).execute( AV12EmpBaseCod2, GXv_char1, GXv_boolean2) ;
               gettxtbasecod2.this.AV10txt = GXv_char1[0] ;
            }
            else
            {
               AV10txt = "" ;
            }
         }
      }
      else
      {
         AV10txt = GXutil.trim( AV12EmpBaseCod2) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = gettxtbasecod2.this.AV10txt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10txt = "" ;
      GXv_char1 = new String[1] ;
      GXv_boolean2 = new boolean[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11CliCod ;
   private String AV8EmpBaseTipo ;
   private String AV9EmpBaseCod1 ;
   private String AV12EmpBaseCod2 ;
   private String GXv_char1[] ;
   private boolean Cond_result ;
   private boolean GXv_boolean2[] ;
   private String AV10txt ;
   private String[] aP4 ;
}

