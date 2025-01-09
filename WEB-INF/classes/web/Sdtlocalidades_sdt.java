package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtlocalidades_sdt extends GxUserType
{
   public Sdtlocalidades_sdt( )
   {
      this(  new ModelContext(Sdtlocalidades_sdt.class));
   }

   public Sdtlocalidades_sdt( ModelContext context )
   {
      super( context, "Sdtlocalidades_sdt");
   }

   public Sdtlocalidades_sdt( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle, context, "Sdtlocalidades_sdt");
   }

   public Sdtlocalidades_sdt( StructSdtlocalidades_sdt struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "Localidades") )
            {
               if ( gxTv_Sdtlocalidades_sdt_Localidades == null )
               {
                  gxTv_Sdtlocalidades_sdt_Localidades = new web.Sdtlocalidades_sdt_Localidades(remoteHandle, context);
               }
               GXSoapError = gxTv_Sdtlocalidades_sdt_Localidades.readxml(oReader, "Localidades") ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "localidades_sdt" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      if ( gxTv_Sdtlocalidades_sdt_Localidades != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_Sdtlocalidades_sdt_Localidades.writexml(oWriter, "Localidades", sNameSpace1);
      }
      oWriter.writeEndElement();
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      if ( gxTv_Sdtlocalidades_sdt_Localidades != null )
      {
         AddObjectProperty("Localidades", gxTv_Sdtlocalidades_sdt_Localidades, false, false);
      }
   }

   public web.Sdtlocalidades_sdt_Localidades getgxTv_Sdtlocalidades_sdt_Localidades( )
   {
      if ( gxTv_Sdtlocalidades_sdt_Localidades == null )
      {
         gxTv_Sdtlocalidades_sdt_Localidades = new web.Sdtlocalidades_sdt_Localidades(remoteHandle, context);
      }
      gxTv_Sdtlocalidades_sdt_Localidades_N = (byte)(0) ;
      gxTv_Sdtlocalidades_sdt_N = (byte)(0) ;
      return gxTv_Sdtlocalidades_sdt_Localidades ;
   }

   public void setgxTv_Sdtlocalidades_sdt_Localidades( web.Sdtlocalidades_sdt_Localidades value )
   {
      gxTv_Sdtlocalidades_sdt_Localidades_N = (byte)(0) ;
      gxTv_Sdtlocalidades_sdt_N = (byte)(0) ;
      gxTv_Sdtlocalidades_sdt_Localidades = value;
   }

   public void setgxTv_Sdtlocalidades_sdt_Localidades_SetNull( )
   {
      gxTv_Sdtlocalidades_sdt_Localidades_N = (byte)(1) ;
      gxTv_Sdtlocalidades_sdt_Localidades = (web.Sdtlocalidades_sdt_Localidades)null;
   }

   public boolean getgxTv_Sdtlocalidades_sdt_Localidades_IsNull( )
   {
      if ( gxTv_Sdtlocalidades_sdt_Localidades == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtlocalidades_sdt_Localidades_N( )
   {
      return gxTv_Sdtlocalidades_sdt_Localidades_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtlocalidades_sdt_Localidades_N = (byte)(1) ;
      gxTv_Sdtlocalidades_sdt_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtlocalidades_sdt_N ;
   }

   public web.Sdtlocalidades_sdt Clone( )
   {
      return (web.Sdtlocalidades_sdt)(clone()) ;
   }

   public void setStruct( web.StructSdtlocalidades_sdt struct )
   {
      setgxTv_Sdtlocalidades_sdt_Localidades(new web.Sdtlocalidades_sdt_Localidades(struct.getLocalidades()));
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtlocalidades_sdt getStruct( )
   {
      web.StructSdtlocalidades_sdt struct = new web.StructSdtlocalidades_sdt ();
      struct.setLocalidades(getgxTv_Sdtlocalidades_sdt_Localidades().getStruct());
      return struct ;
   }

   protected byte gxTv_Sdtlocalidades_sdt_Localidades_N ;
   protected byte gxTv_Sdtlocalidades_sdt_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected web.Sdtlocalidades_sdt_Localidades gxTv_Sdtlocalidades_sdt_Localidades=null ;
}
