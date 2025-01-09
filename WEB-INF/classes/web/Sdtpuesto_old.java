package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtpuesto_old extends GxUserType
{
   public Sdtpuesto_old( )
   {
      this(  new ModelContext(Sdtpuesto_old.class));
   }

   public Sdtpuesto_old( ModelContext context )
   {
      super( context, "Sdtpuesto_old");
   }

   public Sdtpuesto_old( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle, context, "Sdtpuesto_old");
   }

   public Sdtpuesto_old( StructSdtpuesto_old struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PuestoDescrip") )
            {
               gxTv_Sdtpuesto_old_Puestodescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PuestoHorasExt") )
            {
               gxTv_Sdtpuesto_old_Puestohorasext = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "puesto_old" ;
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
      oWriter.writeElement("PuestoDescrip", gxTv_Sdtpuesto_old_Puestodescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PuestoHorasExt", GXutil.booltostr( gxTv_Sdtpuesto_old_Puestohorasext));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
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
      AddObjectProperty("PuestoDescrip", gxTv_Sdtpuesto_old_Puestodescrip, false, false);
      AddObjectProperty("PuestoHorasExt", gxTv_Sdtpuesto_old_Puestohorasext, false, false);
   }

   public String getgxTv_Sdtpuesto_old_Puestodescrip( )
   {
      return gxTv_Sdtpuesto_old_Puestodescrip ;
   }

   public void setgxTv_Sdtpuesto_old_Puestodescrip( String value )
   {
      gxTv_Sdtpuesto_old_N = (byte)(0) ;
      gxTv_Sdtpuesto_old_Puestodescrip = value ;
   }

   public boolean getgxTv_Sdtpuesto_old_Puestohorasext( )
   {
      return gxTv_Sdtpuesto_old_Puestohorasext ;
   }

   public void setgxTv_Sdtpuesto_old_Puestohorasext( boolean value )
   {
      gxTv_Sdtpuesto_old_N = (byte)(0) ;
      gxTv_Sdtpuesto_old_Puestohorasext = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtpuesto_old_Puestodescrip = "" ;
      gxTv_Sdtpuesto_old_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtpuesto_old_N ;
   }

   public web.Sdtpuesto_old Clone( )
   {
      return (web.Sdtpuesto_old)(clone()) ;
   }

   public void setStruct( web.StructSdtpuesto_old struct )
   {
      setgxTv_Sdtpuesto_old_Puestodescrip(struct.getPuestodescrip());
      setgxTv_Sdtpuesto_old_Puestohorasext(struct.getPuestohorasext());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtpuesto_old getStruct( )
   {
      web.StructSdtpuesto_old struct = new web.StructSdtpuesto_old ();
      struct.setPuestodescrip(getgxTv_Sdtpuesto_old_Puestodescrip());
      struct.setPuestohorasext(getgxTv_Sdtpuesto_old_Puestohorasext());
      return struct ;
   }

   protected byte gxTv_Sdtpuesto_old_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean gxTv_Sdtpuesto_old_Puestohorasext ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtpuesto_old_Puestodescrip ;
}

