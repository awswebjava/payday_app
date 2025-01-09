package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_convenios_sdt_conveniosItem extends GxUserType
{
   public Sdtsdt_convenios_sdt_conveniosItem( )
   {
      this(  new ModelContext(Sdtsdt_convenios_sdt_conveniosItem.class));
   }

   public Sdtsdt_convenios_sdt_conveniosItem( ModelContext context )
   {
      super( context, "Sdtsdt_convenios_sdt_conveniosItem");
   }

   public Sdtsdt_convenios_sdt_conveniosItem( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_convenios_sdt_conveniosItem");
   }

   public Sdtsdt_convenios_sdt_conveniosItem( StructSdtsdt_convenios_sdt_conveniosItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveCodigo") )
            {
               gxTv_Sdtsdt_convenios_sdt_conveniosItem_Convecodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveDescri") )
            {
               gxTv_Sdtsdt_convenios_sdt_conveniosItem_Convedescri = oReader.getValue() ;
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
         sName = "sdt_convenios.sdt_conveniosItem" ;
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
      oWriter.writeElement("ConveCodigo", gxTv_Sdtsdt_convenios_sdt_conveniosItem_Convecodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveDescri", gxTv_Sdtsdt_convenios_sdt_conveniosItem_Convedescri);
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
      AddObjectProperty("ConveCodigo", gxTv_Sdtsdt_convenios_sdt_conveniosItem_Convecodigo, false, false);
      AddObjectProperty("ConveDescri", gxTv_Sdtsdt_convenios_sdt_conveniosItem_Convedescri, false, false);
   }

   public String getgxTv_Sdtsdt_convenios_sdt_conveniosItem_Convecodigo( )
   {
      return gxTv_Sdtsdt_convenios_sdt_conveniosItem_Convecodigo ;
   }

   public void setgxTv_Sdtsdt_convenios_sdt_conveniosItem_Convecodigo( String value )
   {
      gxTv_Sdtsdt_convenios_sdt_conveniosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_convenios_sdt_conveniosItem_Convecodigo = value ;
   }

   public String getgxTv_Sdtsdt_convenios_sdt_conveniosItem_Convedescri( )
   {
      return gxTv_Sdtsdt_convenios_sdt_conveniosItem_Convedescri ;
   }

   public void setgxTv_Sdtsdt_convenios_sdt_conveniosItem_Convedescri( String value )
   {
      gxTv_Sdtsdt_convenios_sdt_conveniosItem_N = (byte)(0) ;
      gxTv_Sdtsdt_convenios_sdt_conveniosItem_Convedescri = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_convenios_sdt_conveniosItem_Convecodigo = "" ;
      gxTv_Sdtsdt_convenios_sdt_conveniosItem_N = (byte)(1) ;
      gxTv_Sdtsdt_convenios_sdt_conveniosItem_Convedescri = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_convenios_sdt_conveniosItem_N ;
   }

   public web.Sdtsdt_convenios_sdt_conveniosItem Clone( )
   {
      return (web.Sdtsdt_convenios_sdt_conveniosItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_convenios_sdt_conveniosItem struct )
   {
      setgxTv_Sdtsdt_convenios_sdt_conveniosItem_Convecodigo(struct.getConvecodigo());
      setgxTv_Sdtsdt_convenios_sdt_conveniosItem_Convedescri(struct.getConvedescri());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_convenios_sdt_conveniosItem getStruct( )
   {
      web.StructSdtsdt_convenios_sdt_conveniosItem struct = new web.StructSdtsdt_convenios_sdt_conveniosItem ();
      struct.setConvecodigo(getgxTv_Sdtsdt_convenios_sdt_conveniosItem_Convecodigo());
      struct.setConvedescri(getgxTv_Sdtsdt_convenios_sdt_conveniosItem_Convedescri());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_convenios_sdt_conveniosItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtsdt_convenios_sdt_conveniosItem_Convecodigo ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_convenios_sdt_conveniosItem_Convedescri ;
}

