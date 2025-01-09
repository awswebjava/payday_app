package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class createhashforpsw extends GXProcedure
{
   public createhashforpsw( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( createhashforpsw.class ), "" );
   }

   public createhashforpsw( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      createhashforpsw.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 )
   {
      createhashforpsw.this.AV11password = aP0;
      createhashforpsw.this.AV12parmSalt = aP1;
      createhashforpsw.this.aP2 = aP2;
      createhashforpsw.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! (GXutil.strcmp("", AV12parmSalt)==0) )
      {
         AV9salt = AV12parmSalt ;
      }
      else
      {
         AV9salt = AV8Argon2id.generatesalt() ;
      }
      AV10hash = AV8Argon2id.generateargon2idinteractive(AV11password, AV9salt) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = createhashforpsw.this.AV10hash;
      this.aP3[0] = createhashforpsw.this.AV9salt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10hash = "" ;
      AV9salt = "" ;
      AV8Argon2id = new web.SdtArgon2id(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV11password ;
   private String AV12parmSalt ;
   private String AV10hash ;
   private String AV9salt ;
   private web.SdtArgon2id AV8Argon2id ;
   private String[] aP3 ;
   private String[] aP2 ;
}

