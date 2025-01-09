package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtbanco_old extends GxUserType
{
   public Sdtbanco_old( )
   {
      this(  new ModelContext(Sdtbanco_old.class));
   }

   public Sdtbanco_old( ModelContext context )
   {
      super( context, "Sdtbanco_old");
   }

   public Sdtbanco_old( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle, context, "Sdtbanco_old");
   }

   public Sdtbanco_old( StructSdtbanco_old struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "BanDescrip") )
            {
               gxTv_Sdtbanco_old_Bandescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "BanHabilitado") )
            {
               gxTv_Sdtbanco_old_Banhabilitado = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "BanCUIT") )
            {
               gxTv_Sdtbanco_old_Bancuit = oReader.getValue() ;
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
         sName = "banco_old" ;
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
      oWriter.writeElement("BanDescrip", gxTv_Sdtbanco_old_Bandescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("BanHabilitado", GXutil.booltostr( gxTv_Sdtbanco_old_Banhabilitado));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("BanCUIT", gxTv_Sdtbanco_old_Bancuit);
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
      AddObjectProperty("BanDescrip", gxTv_Sdtbanco_old_Bandescrip, false, false);
      AddObjectProperty("BanHabilitado", gxTv_Sdtbanco_old_Banhabilitado, false, false);
      AddObjectProperty("BanCUIT", gxTv_Sdtbanco_old_Bancuit, false, false);
   }

   public String getgxTv_Sdtbanco_old_Bandescrip( )
   {
      return gxTv_Sdtbanco_old_Bandescrip ;
   }

   public void setgxTv_Sdtbanco_old_Bandescrip( String value )
   {
      gxTv_Sdtbanco_old_N = (byte)(0) ;
      gxTv_Sdtbanco_old_Bandescrip = value ;
   }

   public boolean getgxTv_Sdtbanco_old_Banhabilitado( )
   {
      return gxTv_Sdtbanco_old_Banhabilitado ;
   }

   public void setgxTv_Sdtbanco_old_Banhabilitado( boolean value )
   {
      gxTv_Sdtbanco_old_N = (byte)(0) ;
      gxTv_Sdtbanco_old_Banhabilitado = value ;
   }

   public String getgxTv_Sdtbanco_old_Bancuit( )
   {
      return gxTv_Sdtbanco_old_Bancuit ;
   }

   public void setgxTv_Sdtbanco_old_Bancuit( String value )
   {
      gxTv_Sdtbanco_old_N = (byte)(0) ;
      gxTv_Sdtbanco_old_Bancuit = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtbanco_old_Bandescrip = "" ;
      gxTv_Sdtbanco_old_N = (byte)(1) ;
      gxTv_Sdtbanco_old_Bancuit = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtbanco_old_N ;
   }

   public web.Sdtbanco_old Clone( )
   {
      return (web.Sdtbanco_old)(clone()) ;
   }

   public void setStruct( web.StructSdtbanco_old struct )
   {
      setgxTv_Sdtbanco_old_Bandescrip(struct.getBandescrip());
      setgxTv_Sdtbanco_old_Banhabilitado(struct.getBanhabilitado());
      setgxTv_Sdtbanco_old_Bancuit(struct.getBancuit());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtbanco_old getStruct( )
   {
      web.StructSdtbanco_old struct = new web.StructSdtbanco_old ();
      struct.setBandescrip(getgxTv_Sdtbanco_old_Bandescrip());
      struct.setBanhabilitado(getgxTv_Sdtbanco_old_Banhabilitado());
      struct.setBancuit(getgxTv_Sdtbanco_old_Bancuit());
      return struct ;
   }

   protected byte gxTv_Sdtbanco_old_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtbanco_old_Bancuit ;
   protected String sTagName ;
   protected boolean gxTv_Sdtbanco_old_Banhabilitado ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtbanco_old_Bandescrip ;
}

