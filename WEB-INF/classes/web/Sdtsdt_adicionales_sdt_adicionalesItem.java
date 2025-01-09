package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_adicionales_sdt_adicionalesItem extends GxUserType
{
   public Sdtsdt_adicionales_sdt_adicionalesItem( )
   {
      this(  new ModelContext(Sdtsdt_adicionales_sdt_adicionalesItem.class));
   }

   public Sdtsdt_adicionales_sdt_adicionalesItem( ModelContext context )
   {
      super( context, "Sdtsdt_adicionales_sdt_adicionalesItem");
   }

   public Sdtsdt_adicionales_sdt_adicionalesItem( int remoteHandle ,
                                                  ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_adicionales_sdt_adicionalesItem");
   }

   public Sdtsdt_adicionales_sdt_adicionalesItem( StructSdtsdt_adicionales_sdt_adicionalesItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdicod") )
            {
               gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadicod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveAdiDescri") )
            {
               gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadidescri = oReader.getValue() ;
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
         sName = "sdt_adicionales.sdt_adicionalesItem" ;
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
      oWriter.writeElement("ConveAdicod", gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadicod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveAdiDescri", gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadidescri);
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
      AddObjectProperty("ConveAdicod", gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadicod, false, false);
      AddObjectProperty("ConveAdiDescri", gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadidescri, false, false);
   }

   public String getgxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadicod( )
   {
      return gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadicod ;
   }

   public void setgxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadicod( String value )
   {
      gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_N = (byte)(0) ;
      gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadicod = value ;
   }

   public String getgxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadidescri( )
   {
      return gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadidescri ;
   }

   public void setgxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadidescri( String value )
   {
      gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_N = (byte)(0) ;
      gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadidescri = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadicod = "" ;
      gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_N = (byte)(1) ;
      gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadidescri = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_N ;
   }

   public web.Sdtsdt_adicionales_sdt_adicionalesItem Clone( )
   {
      return (web.Sdtsdt_adicionales_sdt_adicionalesItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_adicionales_sdt_adicionalesItem struct )
   {
      setgxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadicod(struct.getConveadicod());
      setgxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadidescri(struct.getConveadidescri());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_adicionales_sdt_adicionalesItem getStruct( )
   {
      web.StructSdtsdt_adicionales_sdt_adicionalesItem struct = new web.StructSdtsdt_adicionales_sdt_adicionalesItem ();
      struct.setConveadicod(getgxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadicod());
      struct.setConveadidescri(getgxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadidescri());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadicod ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_adicionales_sdt_adicionalesItem_Conveadidescri ;
}

